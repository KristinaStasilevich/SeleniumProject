package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.pages.CatalogPage;
import selenide.pages.MenuPage;

@Listeners({ScreenshotListener.class})
@Feature("Catalog")
public class DucksCatalogTest extends TestBase {
    @Description("The image size changes when you click on the magnifier")
    @Story("Enlarge image in catalog")
    @Test
    public void DucksImageMagnifierTest() {
        MenuPage.clickRubberDucksButton();
        CatalogPage.clickToTheGreenDuckMagnifier();
        CatalogPage.validateGreenDuckLargeImageIsVisible();
    }

    @Description("Images can be scrolled in catalog")
    @Story("Scroll images in catalog")
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
