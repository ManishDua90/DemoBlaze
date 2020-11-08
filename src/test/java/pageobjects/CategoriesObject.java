package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesObject {

    private static WebElement element = null;

    public static WebElement categoryLaptops(WebDriver driver) {
        element = driver.findElement(By.linkText("Laptops"));
        return element;

    }

    public static WebElement categoryMonitors(WebDriver driver) {
        element = driver.findElement(By.linkText("Monitors"));
        return element;

    }
    
    public static WebElement categoryPhones(WebDriver driver) {
        element = driver.findElement(By.linkText("Phones"));
        return element;

    }
}
