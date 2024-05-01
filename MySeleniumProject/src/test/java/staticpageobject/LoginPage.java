package staticpageobject;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static void attemptLogin(WebDriver driver, String email, String password) {
        driver.findElement(Locators.getLocator("LoginPage.loginInput")).sendKeys(email);
        driver.findElement(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
        driver.findElement(Locators.getLocator("LoginPage.loginButton")).click();
    }
}