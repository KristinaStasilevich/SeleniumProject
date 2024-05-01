package staticpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {
    public static void clickHomeButton(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.homeButton")).click();
    }

    public static void clickRubberDucksButton(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.rubberDucksButton")).click();
    }

    public static void clickSubcategoryButton(WebDriver driver) {
        driver.findElement(Locators.getLocator("MenuPage.subcategoryButton")).click();
    }

    public static void moveToRubberDucksButton(WebDriver driver) {
        new Actions(driver).moveToElement(driver.findElement(Locators.getLocator("MenuPage.rubberDucksButton"))).perform();
    }
}
