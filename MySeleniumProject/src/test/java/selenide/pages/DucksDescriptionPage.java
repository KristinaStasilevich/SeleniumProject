package selenide.pages;

import com.codeborne.selenide.Selenide;
import selenide.Locators;

import static com.codeborne.selenide.Selenide.$;

public class DucksDescriptionPage {

    public static void AddItemToCart() {
        Selenide.$(Locators.getLocator("DescriptionPage.addToCartButton")).click();
    }
}
