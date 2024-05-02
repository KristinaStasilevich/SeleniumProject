package selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class MenuPage {
    public static void clickHomeButton() {
        $(Locators.getLocator("MenuPage.homeButton")).click();
    }

    public static void clickRubberDucksButton() {
        $(Locators.getLocator("MenuPage.rubberDucksButton")).click();
    }

    public static void clickSubcategoryButton() {
        $(Locators.getLocator("MenuPage.subcategoryButton")).click();
    }

    public static void moveToRubberDucksButton() {
        actions().moveToElement($(Locators.getLocator("MenuPage.rubberDucksButton"))).perform();
    }
}
