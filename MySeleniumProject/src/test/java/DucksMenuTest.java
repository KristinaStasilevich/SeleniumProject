import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class DucksMenuTest {

    @Test
    public void homeMenuTest() {
        String expectedTitle = "Online Store | My Store";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");

        WebElement homeButton = driver.findElement(By.cssSelector(".fa.fa-home"));
        homeButton.click();
        WebElement duckPicture = driver.findElement(By.cssSelector("#slider [src='/images/slides/1-lonely-duck.jpg']"));
        boolean duckPictureIsVisible = duckPicture.isDisplayed();
        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(duckPictureIsVisible, "Picture is not visible");
        softAssert.assertEquals(title, expectedTitle);
        softAssert.assertAll();

        driver.quit();

    }

    @Test
    public void rubberDucksMenuTest() {
        String expectedTitle = "Rubber Ducks | My Store";
        String expectedPageName = "Rubber Ducks";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksButton = driver.findElement(By.cssSelector("#site-menu [href ='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        rubberDucksButton.click();

        WebElement pageName = driver.findElement(By.cssSelector("#box-category h1.title"));
        String name = pageName.getText();
        boolean nameIsVisible = pageName.isDisplayed();
        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, expectedPageName);
        softAssert.assertTrue(nameIsVisible, "Page name is not visible");
        softAssert.assertEquals(title, expectedTitle);
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void subcategoryMenuTest() {
        String expectedTitle = "Subcategory | My Store";
        String expectedPageName = "Subcategory";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksButton = driver.findElement(By.cssSelector("#site-menu [href ='https://litecart.stqa.ru/en/" +
                "rubber-ducks-c-1/']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksButton).perform();
        WebElement subcategoryButton = driver.findElement(By.cssSelector(".category-2 [href='https://litecart.stqa.ru/en/" +
                "rubber-ducks-c-1/subcategory-c-2/']"));
        subcategoryButton.click();

        WebElement pageName = driver.findElement(By.cssSelector("#box-category h1.title"));
        String name = pageName.getText();
        boolean nameIsVisible = pageName.isDisplayed();
        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, expectedPageName);
        softAssert.assertTrue(nameIsVisible, "Page name is not visible");
        softAssert.assertEquals(title, expectedTitle);
        softAssert.assertAll();

        driver.quit();
    }
}
