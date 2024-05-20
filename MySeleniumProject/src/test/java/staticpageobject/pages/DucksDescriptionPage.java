package staticpageobject.pages;

import org.openqa.selenium.WebDriver;
import staticpageobject.Locators;

public class DucksDescriptionPage {

    public static void AddItemToCart(WebDriver driver) {
        driver.findElement(Locators.getLocator("DescriptionPage.addToCartButton")).click();
    }
}
