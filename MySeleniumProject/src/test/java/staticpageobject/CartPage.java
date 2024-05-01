package staticpageobject;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public static void waitForExpectedIcoQuantity(WebDriver driver, String expectedValue) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBe(Locators.getLocator("CartPage.cartIcoQuantity"), expectedValue));
    }

    public static void waitForUpdatedQuantity(WebDriver driver, String expectedOrderConfirmationQuantity) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBe(Locators.getLocator("CartPage.orderConfirmationQuantity"), expectedOrderConfirmationQuantity));
    }

    public static String getQuantityInBasket(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CartPage.cartIcoQuantity")).getText();
    }

    public static void checkout(WebDriver driver) {
        driver.findElement(Locators.getLocator("CartPage.checkout")).click();
    }

    public static void removeItemsFromCart(WebDriver driver) {
        driver.findElement(Locators.getLocator("CartPage.remove")).click();
    }

    public static String getSuccessRemoveMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CartPage.successRemoveMessage")).getText();
    }

    public static boolean successRemoveMessageTextIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CartPage.successRemoveMessage")).isDisplayed();
    }

    public static void changeItemsQuantity(WebDriver driver, String value) {
        driver.findElement(Locators.getLocator("CartPage.quantity")).sendKeys(Keys.DELETE);
        driver.findElement(Locators.getLocator("CartPage.quantity")).sendKeys(value);
    }

    public static void arrowUpItemsQuantity(WebDriver driver) {
        driver.findElement(Locators.getLocator("CartPage.quantity")).sendKeys(Keys.ARROW_UP);
    }

    public static void updateItemsQuantity(WebDriver driver) {
        driver.findElement(Locators.getLocator("CartPage.updateItemsQuantity")).click();
    }

    public static String getSummaryQuantity(WebDriver driver) {
        return driver.findElement(Locators.getLocator("CartPage.orderConfirmationQuantity")).getText();
    }
}
