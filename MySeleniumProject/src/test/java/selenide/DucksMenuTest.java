package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.pages.CatalogPage;
import selenide.pages.HomePage;
import selenide.pages.MenuPage;

@Listeners({ScreenshotListener.class})
@Feature("Menu")
public class DucksMenuTest extends TestBase {
    @Description("A large image of a duck is displayed by click on the home button")
    @Story("Home button")
    @Test
    public void homeMenuTest() {
        MenuPage.clickHomeButton();
        HomePage.validatePictureIsVisible();
    }

    @Description("The page name became Rubber Ducks by click on the Rubber Ducks button")
    @Story("Rubber ducks button")
    @Test
    public void rubberDucksMenuTest() {
        String expectedPageName = "Rubber Ducks";
        MenuPage.clickRubberDucksButton();
        CatalogPage.validatePage(expectedPageName);
    }

    @Description("The page name became Subcategory by click on the Subcategory button")
    @Story("Subcategory button")
    @Test
    public void subcategoryMenuTest() {
        String expectedPageName = "Subcategory";
        MenuPage.moveToRubberDucksButton();
        MenuPage.clickSubcategoryButton();
        CatalogPage.validatePage(expectedPageName);
    }
}
