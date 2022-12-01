package Personal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SyntaxHRM {



    public static void OpenSyntaxHRM_Chrome(WebDriver x) {
        WebDriverManager.chromedriver().setup();
        x=new ChromeDriver();
        x.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        x.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        x.manage().window().maximize();
    }
}



