package selenide;

import org.testng.annotations.Test;
import selenide.pages.CatalogPage;
import selenide.pages.HomePage;
import selenide.pages.MenuPage;

public class DucksMenuTest extends TestBase {
    @Test
    public void homeMenuTest() {
        MenuPage.clickHomeButton();
        HomePage.validatePictureIsVisible();
    }

    @Test
    public void rubberDucksMenuTest() {
        String expectedPageName = "Rubber Ducks";
        MenuPage.clickRubberDucksButton();
        CatalogPage.validatePage(expectedPageName);
    }

    @Test
    public void subcategoryMenuTest() {
        String expectedPageName = "Subcategory";
        MenuPage.moveToRubberDucksButton();
        MenuPage.clickSubcategoryButton();
        CatalogPage.validatePage(expectedPageName);
    }
}
