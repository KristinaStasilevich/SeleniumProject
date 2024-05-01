package staticpageobject;

import org.openqa.selenium.WebDriver;

public class HomePage {
    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.errorMessage")).getText();
    }

    public static String getSuccessMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successMessage")).getText();
    }

    public static String getErrorMessageBgColor(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.errorMessage")).getCssValue("background-color");
    }

    public static String getSuccessMessageBgColor(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successMessage")).getCssValue("background-color");
    }

    public static boolean errorMessageIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.errorMessage")).isDisplayed();
    }

    public static boolean successMessageIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successMessage")).isDisplayed();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(Locators.getLocator("HomePage.logoutButton")).click();
    }

    public static boolean duckPictureIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.duckPicture")).isDisplayed();
    }
}