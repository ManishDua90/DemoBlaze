package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {

	 private static WebElement element = null;

	    public static WebElement addToCartButton(WebDriver driver) {
	        element = driver.findElement(By.cssSelector("#tbodyid.col-md-7.col-sm-12.col-xs-12 div.row div.col-sm-12.col-md-6.col-lg-6 a.btn.btn-success.btn-lg"));
	        return element;
	    }
}
