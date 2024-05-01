package staticpageobject;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DucksCatalogTest extends TestBase {
    @Test
    public void DucksImageMagnifierTest() {
        MenuPage.clickRubberDucksButton(driver);
        CatalogPage.clickToTheGreenDuckMagnifier(driver);

        Assert.assertTrue(CatalogPage.greenDuckLargeImageIsVisible(driver), "Image is not visible");
    }

    @Test
    public void DucksScrollImagesTest() {
        String expectedColorOfDuck = "Red Duck";

        MenuPage.clickRubberDucksButton(driver);
        CatalogPage.clickToTheGreenDuckMagnifier(driver);
        CatalogPage.scrollImagesToRight(driver);
        CatalogPage.waitForTheTextChange(driver, "Red Duck");
        CatalogPage.scrollImagesToRight(driver);
        CatalogPage.waitForTheTextChange(driver, "Blue Duck");
        CatalogPage.scrollImagesToLeft(driver);
        CatalogPage.waitForTheTextChange(driver, "Red Duck");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(CatalogPage.rightIcoIsVisible(driver), "Right icon is not visible");
        softAssert.assertTrue(CatalogPage.leftIcoIsVisible(driver), "Left icon is not visible");
        softAssert.assertEquals(CatalogPage.getColorOfDuck(driver), expectedColorOfDuck);
        softAssert.assertAll();
    }
}
