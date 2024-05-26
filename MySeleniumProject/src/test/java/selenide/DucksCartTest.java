package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.pages.CartPage;
import selenide.pages.CatalogPage;
import selenide.pages.DucksDescriptionPage;


@Listeners({ScreenshotListener.class})
@Feature("Cart")
public class DucksCartTest extends TestBase {
    @Description("Quantity of ducks changes, when duck added to cart")
    @Story("Add to cart")
    @Test
    public void addToCartTest() {
        CatalogPage.chooseTheBlueDuckImage();
        DucksDescriptionPage.AddItemToCart();
        CartPage.waitForExpectedIcoQuantity( "1");
        CartPage.validateQuantityInBasket("2");
    }

    @Description("After clicking the remove button there are no items in the cart")
    @Story("Remove from cart")
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

    @Description("The summary quantity changes when the number of items in the cart changes " +
            "and the update button is clicked")
    @Story("Update quantity in cart")
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