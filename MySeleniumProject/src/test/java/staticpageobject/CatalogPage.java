package staticpageobject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {
    public static String getPageName(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CatalogPage.pageName")).getText();
    }

    public static boolean pageNameIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CatalogPage.pageName")).isDisplayed();
    }

    public static void chooseTheBlueDuckImage(WebDriver driver) {
        driver.findElement(Locators.getLocator("CatalogPage.blueDuckImage")).click();
    }

    public static void clickToTheGreenDuckMagnifier(WebDriver driver) {
        driver.findElement(Locators.getLocator("CatalogPage.greenDuckMagnifier")).click();
    }

    public static boolean greenDuckLargeImageIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CatalogPage.greenDuckLargeImage")).isDisplayed();
    }

    public static void scrollImagesToRight(WebDriver driver) {
        driver.findElement(Locators.getLocator("CatalogPage.rightSideOfImage")).click();
    }

    public static void scrollImagesToLeft(WebDriver driver) {
        driver.findElement(Locators.getLocator("CatalogPage.leftSideOfImage")).click();
    }

    public static void waitForTheTextChange(WebDriver driver, String expectedColorOfDuck) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBe(Locators.getLocator("CatalogPage.colorOfDuck"), expectedColorOfDuck));
    }

    public static String getColorOfDuck(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CatalogPage.colorOfDuck")).getText();
    }

    public static boolean rightIcoIsVisible(WebDriver driver) {
        new Actions(driver).moveToElement(driver.findElement(Locators.getLocator("CatalogPage.rightSideOfImage"))).perform();
        return driver.findElement(Locators.getLocator("CatalogPage.rightIco")).isDisplayed();
    }

    public static boolean leftIcoIsVisible(WebDriver driver) {
        new Actions(driver).moveToElement(driver.findElement(Locators.getLocator("CatalogPage.leftSideOfImage"))).perform();
        return driver.findElement(Locators.getLocator("CatalogPage.leftIco")).isDisplayed();
    }
}