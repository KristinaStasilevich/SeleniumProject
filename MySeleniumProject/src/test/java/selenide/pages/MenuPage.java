package selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import selenide.Locators;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class MenuPage {
    @Step("Click home button")
    public static void clickHomeButton() {
        Selenide.$(Locators.getLocator("MenuPage.homeButton")).click();
    }

    @Step("Click rubber ducks button")
    public static void clickRubberDucksButton() {
        $(Locators.getLocator("MenuPage.rubberDucksButton")).click();
    }

    @Step("Click subcategory button")
    public static void clickSubcategoryButton() {
        $(Locators.getLocator("MenuPage.subcategoryButton")).click();
    }

    @Step("Move to rubber ducks button")
    public static void moveToRubberDucksButton() {
        actions().moveToElement($(Locators.getLocator("MenuPage.rubberDucksButton"))).perform();
    }
}
