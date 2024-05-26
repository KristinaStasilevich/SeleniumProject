package staticpageobject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    protected void setup() {
        Browser browser = Browser.valueOf(System.getProperty("browser","chrome")) ;

        driver = switch(browser) {
            case chrome -> new ChromeDriver();
            case edge -> new EdgeDriver();
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    protected void teardown() {
        this.driver.quit();
    }
}

