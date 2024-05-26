package selenide;

import com.codeborne.selenide.Selenide;
import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Calendar;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshot = Selenide.screenshot(OutputType.FILE);
            ReportPortal.emitLog(testResult.getMethod().getMethodName(), "ERROR",
                    Calendar.getInstance().getTime(), screenshot);
        }
    }
}
