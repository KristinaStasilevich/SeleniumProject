package selenide.pages;

import com.codeborne.selenide.Selenide;
import selenide.Locators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static void attemptLogin(String email, String password) {
        Selenide.$(Locators.getLocator("LoginPage.loginInput")).sendKeys(email);
        $(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
        $(Locators.getLocator("LoginPage.loginButton")).click();
    }
}