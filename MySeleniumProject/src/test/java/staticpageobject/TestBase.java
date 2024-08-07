package staticpageobject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Browsers.*;
import static org.openqa.selenium.Platform.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    protected void setup() throws MalformedURLException {
        Browser browser = Browser.valueOf(System.getProperty("browser","chrome"));

        Platform platform = Platform.valueOf(System.getProperty("os", "windows"));

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("acceptInsecureCerts", true);

        switch(browser) {
            case chrome -> caps.setBrowserName(CHROME);
            case edge -> caps.setBrowserName(EDGE);
            case firefox -> caps.setBrowserName(FIREFOX);
        }

        switch(platform) {
            case windows-> caps.setPlatform(WINDOWS);
            case  linux-> caps.setPlatform(LINUX);
        }

        //caps.setPlatform(WINDOWS);
        //caps.setBrowserName(FIREFOX);
        //
        // caps.setBrowserName(CHROME);
        //caps.setBrowserName(EDGE);

        driver = new RemoteWebDriver(new URL("http://192.168.137.1:4444/wd/hub"), caps);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    protected void teardown() {
        driver.quit();
    }
}

