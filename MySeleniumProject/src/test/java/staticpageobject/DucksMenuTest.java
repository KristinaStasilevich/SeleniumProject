package staticpageobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DucksMenuTest extends TestBase {
    @Test
    public void homeMenuTest() {
        String expectedTitle = "Online Store | My Store";

        MenuPage.clickHomeButton(driver);

        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(HomePage.duckPictureIsVisible(driver), "Picture is not visible");
        softAssert.assertEquals(title, expectedTitle);
        softAssert.assertAll();
    }

    @Test
    public void rubberDucksMenuTest() {
        String expectedTitle = "Rubber Ducks | My Store";
        String expectedPageName = "Rubber Ducks";

        MenuPage.clickRubberDucksButton(driver);

        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(CatalogPage.getPageName(driver), expectedPageName);
        softAssert.assertTrue(CatalogPage.pageNameIsVisible(driver), "Page name is not visible");
        softAssert.assertEquals(title, expectedTitle);
        softAssert.assertAll();
    }

    @Test
    public void subcategoryMenuTest() {
        String expectedTitle = "Subcategory | My Store";
        String expectedPageName = "Subcategory";

        MenuPage.moveToRubberDucksButton(driver);
        MenuPage.clickSubcategoryButton(driver);

        String title = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(CatalogPage.getPageName(driver), expectedPageName);
        softAssert.assertTrue(CatalogPage.pageNameIsVisible(driver), "Page name is not visible");
        softAssert.assertEquals(title, expectedTitle);
        softAssert.assertAll();
    }
}
