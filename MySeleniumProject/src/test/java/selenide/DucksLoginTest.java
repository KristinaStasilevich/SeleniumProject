package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.pages.HomePage;
import selenide.pages.LoginPage;

@Listeners({ScreenshotListener.class})
@Feature("Authorization")
public class DucksLoginTest extends TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166)";

    @Description("Successful authorization when entering correct credentials")
    @Story("Successful authorization")
    @Test
    public void ducksCorrectLoginTest() {
        String expectedSuccessMessageText = "You are now logged in as Kristina Stasilevich.";
        LoginPage.attemptLogin("kristinast.test@gmail.com", "Qwerty123");
        HomePage.validateSuccessMessage(expectedSuccessMessageText, LIGHT_GREEN);
        HomePage.logout();
    }

    @Description("Unsuccessful authorization when entering incorrect credentials")
    @Story("Unsuccessful authorization")
    @Test
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";
        LoginPage.attemptLogin("kristinast.test@gmail.com", "Qwerty");
        HomePage.validateErrorMessage(expectedErrorMessageText, LIGHT_PINK);
    }

    @Description("Successful exit from personal account by clicking the logout button")
    @Story("Logout")
    @Test
    public void ducksLogoutTest() {
        String expectedLogoutMessageText = "You are now logged out.";
        LoginPage.attemptLogin("kristinast.test@gmail.com", "Qwerty123");
        HomePage.logout();
        HomePage.validateLogoutMessage(expectedLogoutMessageText, LIGHT_GREEN);
    }
}