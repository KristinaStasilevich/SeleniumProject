package selenide;

import org.testng.annotations.Test;
import selenide.pages.CatalogPage;
import selenide.pages.MenuPage;

public class DucksCatalogTest extends TestBase {
    @Test
    public void DucksImageMagnifierTest() {
        MenuPage.clickRubberDucksButton();
        CatalogPage.clickToTheGreenDuckMagnifier();
        CatalogPage.validateGreenDuckLargeImageIsVisible();
    }

    @Test
    public void DucksScrollImagesTest() {
        String expectedColorOfDuck = "Red Duck";

        MenuPage.clickRubberDucksButton();
        CatalogPage.clickToTheGreenDuckMagnifier();
        CatalogPage.scrollImagesToRight("Red Duck");
        CatalogPage.scrollImagesToRight("Blue Duck");
        CatalogPage.scrollImagesToLeft("Red Duck");
        CatalogPage.validateScrollImage(expectedColorOfDuck);
    }
}
