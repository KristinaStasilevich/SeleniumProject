package selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static void logout() {
        $(Locators.getLocator("HomePage.logoutButton")).click();
    }

    public static void validateErrorMessage(String expectedMessage, String bgColor) {
        $(Locators.getLocator("HomePage.errorMessage")).shouldHave(text(expectedMessage));
        $(Locators.getLocator("HomePage.errorMessage")).shouldHave(cssValue("background-color", bgColor));
        $(Locators.getLocator("HomePage.errorMessage")).shouldBe(visible);
    }

    public static void validateSuccessMessage(String expectedMessage, String bgColor) {
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(text(expectedMessage));
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(cssValue("background-color", bgColor));
        $(Locators.getLocator("HomePage.successMessage")).shouldBe(visible);
    }

    public static void validateLogoutMessage(String expectedMessage, String bgColor) {
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(text(expectedMessage));
        $(Locators.getLocator("HomePage.successMessage")).shouldHave(cssValue("background-color", bgColor));
        $(Locators.getLocator("HomePage.successMessage")).shouldBe(visible);
    }

    public static void validatePictureIsVisible() {
        $(Locators.getLocator("HomePage.duckPicture")).shouldBe(visible);
    }
}