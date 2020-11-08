package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrder {

	 private static WebElement element = null;
	 public static WebElement totalOrderAmount(WebDriver driver) {
	        element = driver.findElement(By.id("totalm"));
	        return element;
	    }
	 
	 public static WebElement orderName(WebDriver driver) {
	        element = driver.findElement(By.id("name"));
	        return element;
	    }
	 
	 public static WebElement orderCity(WebDriver driver) {
	        element = driver.findElement(By.id("city"));
	        return element;
	    }
	 
	 public static WebElement orderCreditCard(WebDriver driver) {
	        element = driver.findElement(By.id("card"));
	        return element;
	    }
	 
	 public static WebElement orderPurchaseButton(WebDriver driver) {
	        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
	        return element;
	    }
	 
	 public static WebElement orderMonth(WebDriver driver) {
	        element = driver.findElement(By.id("month"));
	        return element;
	    }
	 
	 public static WebElement orderYear(WebDriver driver) {
	        element = driver.findElement(By.id("year"));
	        return element;
	    }
	 
	 public static WebElement orderCountry(WebDriver driver) {
	        element = driver.findElement(By.id("country"));
	        return element;
	    }
	 
	 public static WebElement orderPlacedOkButton(WebDriver driver) {
	        element = driver.findElement(By.xpath("//div[7]/div/button"));
	        
	        return element;
	    }
	 
	 
}
