package selenide;

import org.testng.annotations.Test;
import selenide.pages.HomePage;
import selenide.pages.LoginPage;

public class DucksLoginTest extends TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    @Test
    public void ducksCorrectLoginTest() {
        String expectedSuccessMessageText = "You are now logged in as Kristina Stasilevich.";
        LoginPage.attemptLogin("kristinast.test@gmail.com", "Qwerty123");
        HomePage.validateSuccessMessage(expectedSuccessMessageText, LIGHT_GREEN);
        HomePage.logout();
    }

    @Test
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";
        LoginPage.attemptLogin("kristinast.test@gmail.com", "Qwerty");
        HomePage.validateErrorMessage(expectedErrorMessageText, LIGHT_PINK);
    }

    @Test
    public void ducksLogoutTest() {
        String expectedLogoutMessageText = "You are now logged out.";
        LoginPage.attemptLogin("kristinast.test@gmail.com", "Qwerty123");
        HomePage.logout();
        HomePage.validateLogoutMessage(expectedLogoutMessageText, LIGHT_GREEN);
    }
}