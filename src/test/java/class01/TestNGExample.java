package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGExample {
    WebDriver x;
    @BeforeMethod (alwaysRun = true)
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        x=new ChromeDriver();
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.manage().window().maximize();
        x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod(alwaysRun= true)
    public void CloseBrowser(){
        x.quit();
    }

    @Test (groups="smoke")
    public void LoginFunctionality(){
        WebElement userName = x.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("admin");

        WebElement password = x.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        WebElement logIn = x.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
    }

    @Test
    public void LoginBtnVerification() {
        WebElement logIn = x.findElement(By.xpath("//input[@id='btnLogin']"));
        System.out.println(logIn.isDisplayed());
    }








}
