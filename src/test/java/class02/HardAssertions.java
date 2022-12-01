package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HardAssertions {
    WebDriver x;
    @BeforeMethod(alwaysRun = true)
    public void launchWebsite(){
        WebDriverManager.chromedriver().setup();
        x=new ChromeDriver();
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        x.manage().window().maximize();
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        x.quit();
    }
    @Test(groups = "regression")
    public void invalidCredentials (){
        x.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        x.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("wrongPassword");
        x.findElement(By.xpath("//input[@id='btnLogin']")).click();
        var text = x.findElement(By.xpath("//span[@id='spanMessage']")).getText();
        System.out.println(text);

        Assert.assertEquals(text,"Invalid credentials");
        System.out.println("im here after the 1st assertion");// if assertion fails the rest will not run
        Assert.assertTrue(x.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed());

    }
}
