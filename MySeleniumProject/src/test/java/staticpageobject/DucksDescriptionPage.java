package staticpageobject;

import org.openqa.selenium.WebDriver;

public class DucksDescriptionPage {

    public static void AddItemToCart(WebDriver driver) {
        driver.findElement(Locators.getLocator("DescriptionPage.addToCartButton")).click();
    }
}
