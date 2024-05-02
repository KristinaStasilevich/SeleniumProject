package selenide;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public static void waitForExpectedIcoQuantity(String expectedValue) {
        $(Locators.getLocator("CartPage.cartIcoQuantity")).shouldHave(text(expectedValue));
    }

    public static void waitForUpdatedQuantity(String expectedOrderConfirmationQuantity) {
        $(Locators.getLocator("CartPage.orderConfirmationQuantity")).shouldHave(text(expectedOrderConfirmationQuantity));
    }

    public static void checkout() {
        $(Locators.getLocator("CartPage.checkout")).click();
    }

    public static void removeItemsFromCart() {
        $(Locators.getLocator("CartPage.remove")).click();
    }

    public static void changeItemsQuantity(String value) {
        $(Locators.getLocator("CartPage.quantity")).sendKeys(Keys.DELETE);
        $(Locators.getLocator("CartPage.quantity")).sendKeys(value);
    }

    public static void arrowUpItemsQuantity() {
        $(Locators.getLocator("CartPage.quantity")).sendKeys(Keys.ARROW_UP);
    }

    public static void updateItemsQuantity() {
        $(Locators.getLocator("CartPage.updateItemsQuantity")).click();
    }

    public static void validateQuantityInBasket(String expectedQuantity){
        $(Locators.getLocator("CartPage.cartIcoQuantity")).shouldHave(text(expectedQuantity));
    }

    public static void validateRemove(String expectedText) {
        $(Locators.getLocator("CartPage.successRemoveMessage")).shouldHave(text(expectedText));
        $(Locators.getLocator("CartPage.successRemoveMessage")).shouldBe(visible);
    }

    public static void validateSummaryQuantity(String expectedOrderSummaryQuantity) {
        $(Locators.getLocator("CartPage.orderConfirmationQuantity")).shouldBe(text(expectedOrderSummaryQuantity));

    }
}
