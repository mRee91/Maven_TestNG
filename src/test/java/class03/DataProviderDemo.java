package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {
    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"
    WebDriver x;

    @DataProvider(name="credentials")
    public Object[][] data() {

        Object[][] LoginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return LoginData;
    }

    @BeforeMethod
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        x = new ChromeDriver();
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.manage().window().maximize();
        x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void CloseBrowser() {
        x.quit();
        WebDriverManager.chromedriver().quit();
    }

    @Test(dataProvider = "credentials")
    public void LoginWithInvalidCredentials (String usrnme, String psswrd, String textDisplayed) {
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.findElement(By.name("txtUsername")).sendKeys(usrnme);
        x.findElement(By.name("txtPassword")).sendKeys(psswrd);
        x.findElement(By.id("btnLogin")).click();
        var errrmssg = x.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errrmssg,textDisplayed);
    }
//    @Test
//    public void LoginWithEmptyUsername () {
//        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
//        x.findElement(By.name("txtPassword")).sendKeys("12345", Keys.RETURN);
//        var textDisplayed = x.findElement(By.id("spanMessage")).getText();
//        Assert.assertEquals(textDisplayed,"Username cannot be empty");
//    }
//    @Test
//    public void LoginWithEmptyPassword () {
//        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
//        x.findElement(By.name("txtUsername")).sendKeys("Admin", Keys.RETURN);
//        var textDisplayed = x.findElement(By.id("spanMessage")).getText();
//        Assert.assertEquals(textDisplayed,"Password cannot be empty");
//    }






}
