import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class TheInternetTest {

    @Test
    public void clickToLinkTest() {

        String expectedPageTitle = "Drag and Drop";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");

        WebElement contentPanel = driver.findElement(By.id("content"));
        List<WebElement> links = contentPanel.findElements(By.tagName("a"));
        for (WebElement link: links) {
            System.out.println(link.getText());
        }
        links.get(9).click();

        WebElement pageTitle = driver.findElement(By.tagName("h3"));
        String pageTitleText = pageTitle.getText();
        boolean pageTitleTextIsVisible = pageTitle.isDisplayed();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedPageTitle, pageTitleText);
        softAssert.assertTrue(pageTitleTextIsVisible, "Title text is not visible");
        softAssert.assertAll();

        driver.quit();
    }
}
