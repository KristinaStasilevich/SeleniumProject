package staticpageobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DucksLoginTest extends TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    @Test
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";

        LoginPage.attemptLogin(driver, "kristinast.test@gmail.com", "Qwerty");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getErrorMessageText(driver), expectedErrorMessageText);
        softAssert.assertEquals(HomePage.getErrorMessageBgColor(driver), LIGHT_PINK);
        softAssert.assertTrue(HomePage.errorMessageIsVisible(driver), "Error message is not visible");
        softAssert.assertAll();
    }

    @Test
    public void ducksCorrectLoginTest() {
        String expectedSuccessMessageText = "You are now logged in as Kristina Stasilevich.";

        LoginPage.attemptLogin(driver, "kristinast.test@gmail.com", "Qwerty123");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getSuccessMessageText(driver), expectedSuccessMessageText);
        softAssert.assertEquals(HomePage.getSuccessMessageBgColor(driver), LIGHT_GREEN);
        softAssert.assertTrue(HomePage.successMessageIsVisible(driver), "Message is not visible");
        softAssert.assertAll();
    }

    @Test
    public void ducksLogoutTest() {
        String expectedLogoutMessageText = "You are now logged out.";

        LoginPage.attemptLogin(driver, "kristinast.test@gmail.com", "Qwerty123");
        HomePage.logout(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getSuccessMessageText(driver), expectedLogoutMessageText);
        softAssert.assertEquals(HomePage.getSuccessMessageBgColor(driver), LIGHT_GREEN);
        softAssert.assertTrue(HomePage.successMessageIsVisible(driver), "Message is not visible");
        softAssert.assertAll();
    }
}