package selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import selenide.Locators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CatalogPage {
    @Step("Click blue duck image")
    public static void chooseTheBlueDuckImage() {
        Selenide.$(Locators.getLocator("CatalogPage.blueDuckImage")).click();
    }

    @Step("Click green duck magnifier")
    public static void clickToTheGreenDuckMagnifier() {
        $(Locators.getLocator("CatalogPage.greenDuckMagnifier")).click();
    }

    @Step("Scroll images to right")
    public static void scrollImagesToRight(String expectedColorOfDuck) {
        $(Locators.getLocator("CatalogPage.rightSideOfImage")).click();
        $(Locators.getLocator("CatalogPage.colorOfDuck")).shouldHave(text(expectedColorOfDuck));
    }

    @Step("Scroll images to left")
    public static void scrollImagesToLeft(String expectedColorOfDuck) {
        $(Locators.getLocator("CatalogPage.leftSideOfImage")).click();
        $(Locators.getLocator("CatalogPage.colorOfDuck")).shouldHave(text(expectedColorOfDuck));
    }

    @Step("Validate color of duck")
    public static void validateScrollImage(String expectedColor) {
        isRightArrowVisible();
        isLeftArrowVisible();
        validateColorOfDuck(expectedColor);
    }

    @Step("Check by displaying the right arrow")
    public static void isRightArrowVisible() {
        actions().moveToElement($(Locators.getLocator("CatalogPage.rightSideOfImage"))).perform();
        $(Locators.getLocator("CatalogPage.rightIco")).shouldBe(visible);
    }

    @Step("Check by displaying the left arrow")
    public static void isLeftArrowVisible() {
        actions().moveToElement($(Locators.getLocator("CatalogPage.leftSideOfImage"))).perform();
        $(Locators.getLocator("CatalogPage.leftIco")).shouldBe(visible);
    }

    @Step("Validate color of duck")
    public static void validateColorOfDuck(String expectedColor) {
        $(Locators.getLocator("CatalogPage.colorOfDuck")).shouldHave(text(expectedColor));
    }

    @Step("Validate green duck large image is visible")
    public static void validateGreenDuckLargeImageIsVisible() {
        $(Locators.getLocator("CatalogPage.greenDuckLargeImage")).shouldBe(visible);
    }

    @Step("Check that the page name is as expected")
    public static void validatePage(String expectedName) {
        $(Locators.getLocator("CatalogPage.pageName")).shouldHave(text(expectedName));
        $(Locators.getLocator("CatalogPage.pageName")).shouldBe(visible);
    }
}