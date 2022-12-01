package class04;

import Personal.SyntaxHRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver x;

    @BeforeMethod public void launchWebsite() {
        //SyntaxHRM.OpenSyntaxHRM_Chrome(x); <-- This doesnt work???
        WebDriverManager.chromedriver().setup();
        x=new ChromeDriver();
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        x.manage().window().maximize();}

    @AfterMethod public void closeBrowser () {x.quit();}

    @Test
    public void LoginWithInvalidCredentials () {
        x.findElement(By.name("txtUsername")).sendKeys("Admin");
        x.findElement(By.name("txtPassword")).sendKeys("12345");
        x.findElement(By.id("btnLogin")).click();
        var errrmssg = x.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errrmssg,"Invalid credentials");
    }

}
