package staticpageobject;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DucksCartTest extends TestBase {
    @Test
    public void addToCartTest() {
        CatalogPage.chooseTheBlueDuckImage(driver);
        DucksDescriptionPage.AddItemToCart(driver);
        CartPage.waitForExpectedIcoQuantity(driver, "1");

        Assert.assertEquals(CartPage.getQuantityInBasket(driver), "1");
    }

    @Test
    public void removeFromCartTest() {
        String expectedMessageText = "There are no items in your cart.";

        CatalogPage.chooseTheBlueDuckImage(driver);
        DucksDescriptionPage.AddItemToCart(driver);
        CartPage.waitForExpectedIcoQuantity(driver, "1");
        CartPage.checkout(driver);
        CartPage.removeItemsFromCart(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(CartPage.getSuccessRemoveMessageText(driver), expectedMessageText);
        softAssert.assertTrue(CartPage.successRemoveMessageTextIsVisible(driver), "Message is not visible");
        softAssert.assertAll();
    }

    @Test
    public void updateItemsQuantityTest() {
        String expectedOrderSummaryQuantity = "6";

        CatalogPage.chooseTheBlueDuckImage(driver);
        DucksDescriptionPage.AddItemToCart(driver);
        CartPage.waitForExpectedIcoQuantity(driver, "1");
        CartPage.checkout(driver);
        CartPage.changeItemsQuantity(driver, "5");
        CartPage.arrowUpItemsQuantity(driver);
        CartPage.updateItemsQuantity(driver);
        CartPage.waitForUpdatedQuantity(driver, "6");

        Assert.assertEquals(CartPage.getSummaryQuantity(driver), expectedOrderSummaryQuantity);
    }
}