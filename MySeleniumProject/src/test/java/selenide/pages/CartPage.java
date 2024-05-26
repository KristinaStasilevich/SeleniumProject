package selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import selenide.Locators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    @Step("Validate quantity in cart")
    public static void waitForExpectedIcoQuantity(String expectedValue) {
        Selenide.$(Locators.getLocator("CartPage.cartIcoQuantity")).shouldHave(text(expectedValue));
    }

    @Step("Wait for expected quantity")
    public static void waitForUpdatedQuantity(String expectedOrderConfirmationQuantity) {
        $(Locators.getLocator("CartPage.orderConfirmationQuantity")).shouldHave(text(expectedOrderConfirmationQuantity));
    }

    @Step("Click checkout button")
    public static void checkout() {
        $(Locators.getLocator("CartPage.checkout")).click();
    }

    @Step("Click remove button")
    public static void removeItemsFromCart() {
        $(Locators.getLocator("CartPage.remove")).click();
    }

    @Step("Change quantity in cart")
    public static void changeItemsQuantity(String value) {
        $(Locators.getLocator("CartPage.quantity")).sendKeys(Keys.DELETE);
        $(Locators.getLocator("CartPage.quantity")).sendKeys(value);
    }

    @Step("Increase the quantity in the cart")
    public static void arrowUpItemsQuantity() {
        $(Locators.getLocator("CartPage.quantity")).sendKeys(Keys.ARROW_UP);
    }

    @Step("Click update button")
    public static void updateItemsQuantity() {
        $(Locators.getLocator("CartPage.updateItemsQuantity")).click();
    }

    @Step("Validate quantity in basket")
    public static void validateQuantityInBasket(String expectedQuantity){
        $(Locators.getLocator("CartPage.cartIcoQuantity")).shouldHave(text(expectedQuantity));
    }
    @Step("Validate cart is empty")
    public static void validateRemove(String expectedText) {
        $(Locators.getLocator("CartPage.successRemoveMessage")).shouldHave(text(expectedText));
        $(Locators.getLocator("CartPage.successRemoveMessage")).shouldBe(visible);
    }
    @Step("Validate summary quantity")
    public static void validateSummaryQuantity(String expectedOrderSummaryQuantity) {
        $(Locators.getLocator("CartPage.orderConfirmationQuantity")).shouldBe(text(expectedOrderSummaryQuantity));
    }
}
