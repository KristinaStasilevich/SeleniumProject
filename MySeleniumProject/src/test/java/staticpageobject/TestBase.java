package staticpageobject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    protected void setup() throws MalformedURLException {
        Browser browser = Browser.valueOf(System.getProperty("browser","chrome"));

        String platform = System.getProperty("os", "windows");

        DesiredCapabilities caps = new DesiredCapabilities();

        switch(browser) {
            case chrome -> caps.setBrowserName(CHROME);
            case edge -> caps.setBrowserName(EDGE);
        }

        switch(platform) {
            case "windows" -> caps.setPlatform(Platform.WINDOWS);
            case "linux" -> caps.setPlatform(Platform.LINUX);
        }

        //caps.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL("http://192.168.137.1:4444/wd/hub"), caps);

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

