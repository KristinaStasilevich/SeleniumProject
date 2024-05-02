package selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CatalogPage {

    public static void chooseTheBlueDuckImage() {
        $(Locators.getLocator("CatalogPage.blueDuckImage")).click();
    }

    public static void clickToTheGreenDuckMagnifier() {
        $(Locators.getLocator("CatalogPage.greenDuckMagnifier")).click();
    }

    public static void scrollImagesToRight(String expectedColorOfDuck) {
        $(Locators.getLocator("CatalogPage.rightSideOfImage")).click();
        $(Locators.getLocator("CatalogPage.colorOfDuck")).shouldHave(text(expectedColorOfDuck));
    }

    public static void scrollImagesToLeft(String expectedColorOfDuck) {
        $(Locators.getLocator("CatalogPage.leftSideOfImage")).click();
        $(Locators.getLocator("CatalogPage.colorOfDuck")).shouldHave(text(expectedColorOfDuck));
    }

    public static void validateScrollImage(String expectedColor) {
        actions().moveToElement($(Locators.getLocator("CatalogPage.rightSideOfImage"))).perform();
        $(Locators.getLocator("CatalogPage.rightIco")).shouldBe(visible);
        actions().moveToElement($(Locators.getLocator("CatalogPage.leftSideOfImage"))).perform();
        $(Locators.getLocator("CatalogPage.leftIco")).shouldBe(visible);
        $(Locators.getLocator("CatalogPage.colorOfDuck")).shouldHave(text(expectedColor));
    }

    public static void validateGreenDuckLargeImageIsVisible() {
        $(Locators.getLocator("CatalogPage.greenDuckLargeImage")).shouldBe(visible);
    }

    public static void validatePage(String expectedName) {
        $(Locators.getLocator("CatalogPage.pageName")).shouldHave(text(expectedName));
        $(Locators.getLocator("CatalogPage.pageName")).shouldBe(visible);
    }
}