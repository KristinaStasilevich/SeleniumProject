package selenide;

import org.testng.annotations.Test;

public class DucksCartTest extends TestBase {
    @Test
    public void addToCartTest() {
        CatalogPage.chooseTheBlueDuckImage();
        DucksDescriptionPage.AddItemToCart();
        CartPage.waitForExpectedIcoQuantity( "1");
        CartPage.validateQuantityInBasket("1");
    }

    @Test
    public void removeFromCartTest() {
        String expectedMessageText = "There are no items in your cart.";

        CatalogPage.chooseTheBlueDuckImage();
        DucksDescriptionPage.AddItemToCart();
        CartPage.waitForExpectedIcoQuantity("1");
        CartPage.checkout();
        CartPage.removeItemsFromCart();
        CartPage.validateRemove(expectedMessageText);
    }

    @Test
    public void updateItemsQuantityTest() {
        String expectedOrderSummaryQuantity = "6";

        CatalogPage.chooseTheBlueDuckImage();
        DucksDescriptionPage.AddItemToCart();
        CartPage.waitForExpectedIcoQuantity("1");
        CartPage.checkout();
        CartPage.changeItemsQuantity("5");
        CartPage.arrowUpItemsQuantity();
        CartPage.updateItemsQuantity();
        CartPage.waitForUpdatedQuantity("6");
        CartPage.validateSummaryQuantity(expectedOrderSummaryQuantity);
    }
}