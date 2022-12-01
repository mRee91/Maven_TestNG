package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertionDemo {
        WebDriver x;
        @BeforeMethod
        public void launchWebsite(){
            WebDriverManager.chromedriver().setup();
            x=new ChromeDriver();
            x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
            x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            x.manage().window().maximize();
        }
        @AfterMethod
        public void closeBrowser(){
            x.quit();
        }
        @Test
        public void invalidCredentials (){
            x.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
            x.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("wrongPassword");
            x.findElement(By.xpath("//input[@id='btnLogin']")).click();
            var text = x.findElement(By.xpath("//span[@id='spanMessage']")).getText();
            System.out.println(text);

            SoftAssert softAssert= new SoftAssert();

            softAssert.assertEquals(text,"Invalid credentials");

            System.out.println("im here after the 1st assertion");// if assertion fails the rest will not run

            softAssert.assertTrue(x.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed());

            //assert all assertions that have been made
            softAssert.assertAll();





        }


}
