package selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import selenide.Locators;

public class DucksDescriptionPage {
    @Step("Click add to cart button")
    public static void AddItemToCart() {
        Selenide.$(Locators.getLocator("DescriptionPage.addToCartButton")).click();
    }
}
