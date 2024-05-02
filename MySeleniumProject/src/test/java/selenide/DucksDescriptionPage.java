package selenide;

import static com.codeborne.selenide.Selenide.$;

public class DucksDescriptionPage {

    public static void AddItemToCart() {
        $(Locators.getLocator("DescriptionPage.addToCartButton")).click();
    }
}
