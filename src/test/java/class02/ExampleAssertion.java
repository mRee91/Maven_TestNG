package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
//    goto syntax hrms
//    verify that login btn is displayed
//    verify that login btn is Enabled
//    close the browser

public class ExampleAssertion {
    WebDriver x;
    @BeforeMethod
    public void launchWebsite(){
        WebDriverManager.chromedriver().setup();
        x=new ChromeDriver();
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        x.manage().window().maximize();
    }@AfterMethod
    public void closeBrowser(){
        x.quit();
    }
    @Test
    public void LoginBtnIsDisplyed(){
        //        login btn
        WebElement logIn = x.findElement(By.xpath("//*[@id='btnLogin']"));
        boolean isdisplayed = logIn.isDisplayed();
//        use soft assertion
        SoftAssert soft= new SoftAssert();
//        assertion
        soft.assertTrue(isdisplayed);

//        test if it is enabled
        boolean isenabled = logIn.isEnabled();
//        assertion
        soft.assertTrue(isenabled);
//        assert all
        soft.assertAll();
    }







}
