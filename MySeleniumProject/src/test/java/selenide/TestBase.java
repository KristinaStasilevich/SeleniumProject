package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeMethod
    protected void setup() {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(CHROME);
            caps.setPlatform(Platform.WINDOWS);

            Configuration.remote = "http://192.168.137.1:4444/wd/hub";
            Configuration.browser = CHROME;
            Configuration.browserCapabilities = caps;
            Configuration.pageLoadTimeout = 5000;
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://litecart.stqa.ru/en/";

            open(Configuration.baseUrl);
    }

    @AfterMethod
    public void teardown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshot = Selenide.screenshot(OutputType.FILE);
            try {
                Allure.addAttachment(testResult.getMethod().getMethodName(), new FileInputStream(screenshot));
                ReportPortal.emitLog(testResult.getMethod().getMethodName(), "ERROR",
                        Calendar.getInstance().getTime(), screenshot);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

