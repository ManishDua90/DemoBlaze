package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	 private static WebElement element = null;

	 public static WebElement openCartButton(WebDriver driver) {
	        element = driver.findElement(By.id("cartur"));
	        return element;
	    }
	
	 public static WebElement placeOrderButton(WebDriver driver) {
	        element = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/button"));
	        return element;
	    }
}
