package selenide.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import selenide.Locators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("Attempt to login")
    public static void attemptLogin(String email, String password) {
       enterLogin(email);
       enterPassword(password);
       clickLoginButton();
    }

    @Step("Enter login")
    public static void enterLogin(String email){
        Selenide.$(Locators.getLocator("LoginPage.loginInput")).sendKeys(email);
    }

    @Step("Enter password")
    public static void enterPassword(String password){
        $(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    @Step("Click login button")
    public static void clickLoginButton(){
        $(Locators.getLocator("LoginPage.loginButton")).click();
    }
}