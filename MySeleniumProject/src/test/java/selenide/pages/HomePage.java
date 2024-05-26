package selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import selenide.Locators;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    @Step("Click logout button")
    public static void logout() {
        Selenide.$(Locators.getLocator("HomePage.logoutButton")).click();
    }

    @Step("Validate error message")
    public static void validateErrorMessage(String expectedMessage, String bgColor) {
        $(Locators.getLocator("HomePage.errorMessage")).shouldHave(text(expectedMessage));
        $(Locators.getLocator("HomePage.errorMessage")).shouldHave(cssValue("background-color", bgColor));
        $(Locators.getLocator("HomePage.errorMessage")).shouldBe(visible);
    }

    @Step("Validate success message")
    public static void validateSuccessMessage(String expectedMessage, String bgColor) {
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(text(expectedMessage));
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(cssValue("background-color", bgColor));
        $(Locators.getLocator("HomePage.successMessage")).shouldBe(visible);
    }

    @Step("Validate logout message")
    public static void validateLogoutMessage(String expectedMessage, String bgColor) {
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(text(expectedMessage));
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(cssValue("background-color", bgColor));
        $(Locators.getLocator("HomePage.successMessage")).shouldBe(visible);
    }

    @Step("Validate image is visible")
    public static void validatePictureIsVisible() {
        $(Locators.getLocator("HomePage.duckPicture")).shouldBe(visible);
    }
}