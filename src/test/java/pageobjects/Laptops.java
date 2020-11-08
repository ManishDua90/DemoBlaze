package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Laptops {

    private static WebElement element = null;

    public static WebElement laptopModel(WebDriver driver, String linkText) {
        element = driver.findElement(By.linkText(linkText));
        return element;
    }
}
