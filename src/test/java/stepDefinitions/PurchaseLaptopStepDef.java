package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddToCart;
import pageobjects.Cart;
import pageobjects.CategoriesObject;
import pageobjects.Laptops;
import pageobjects.PlaceOrder;
import utils.Base;

public class PurchaseLaptopStepDef extends Base {
	static Logger log = Logger.getLogger(Log.class.getClass());
	String log4jConfPath = "log4j.properties";
	WebDriver driver;
	private final String CART_TABLE_XPATH_ROWS = "/html/body/div[6]/div/div[1]/div/table/tbody/tr";
	private static String orderAmount = null;
	WebDriverWait wait;
	
	public PurchaseLaptopStepDef() throws Exception {

		PropertyConfigurator.configure(log4jConfPath);
		driver = init();
		wait = new WebDriverWait(driver, 10);

	}

	@Given("^\"(.*)\" screen is open$")
	public void openNavigationMenuItem(String navigationMenuItem) {
		driver.navigate().to(Constants.BASE_URL);
		if (navigationMenuItem.equals("Laptops")) {
			CategoriesObject.categoryLaptops(driver).click();
		} else if (navigationMenuItem.equals("Monitors")) {
			CategoriesObject.categoryMonitors(driver).click();
		} else if (navigationMenuItem.equals("Phones")) {
			CategoriesObject.categoryPhones(driver).click();
		}
	}

	@When("^User adds \"(.*)\" to cart$")
	public void addToCart(String laptopModel) throws InterruptedException {
		Laptops.laptopModel(driver, laptopModel).click();
		AddToCart.addToCartButton(driver).click();
		String window = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().window(window);
		driver.navigate().to(Constants.BASE_URL);
	}

	@When("^Deletes \"(.*)\" laptop from the cart$")
	public void deleteFromCart(String laptopModel) throws InterruptedException {

		Cart.openCartButton(driver).click();
		Thread.sleep(5000);

		List<WebElement> elems = driver.findElements(By.xpath(CART_TABLE_XPATH_ROWS));
		for (WebElement rowElem : elems) {
			List<WebElement> cells = rowElem.findElements(By.xpath("td"));

			if (cells.get(1).getText().equalsIgnoreCase(laptopModel)) {
				System.out.println(cells.get(3).getText());
				cells.get(3).findElement(By.linkText("Delete")).click();

			}
		}
		Thread.sleep(5000);
		driver.navigate().to(Constants.BASE_URL);

	}

	@When("^Clicks Place order and fills details$")
	public void placeOrder(List<Map<String, String>> orderDetails) throws InterruptedException {
		Cart.openCartButton(driver).click();
		Cart.placeOrderButton(driver).click();
		Thread.sleep(3000);
		orderAmount = PlaceOrder.totalOrderAmount(driver).getText();
		
		PlaceOrder.orderName(driver).sendKeys(orderDetails.get(0).get("Name"));
		PlaceOrder.orderCountry(driver).sendKeys(orderDetails.get(0).get("Country"));
		PlaceOrder.orderCity(driver).sendKeys(orderDetails.get(0).get("City"));
		PlaceOrder.orderCreditCard(driver).sendKeys(orderDetails.get(0).get("CreditCard"));
		PlaceOrder.orderMonth(driver).sendKeys(orderDetails.get(0).get("Month"));
		PlaceOrder.orderYear(driver).sendKeys(orderDetails.get(0).get("Year"));
		PlaceOrder.orderPurchaseButton(driver).click();
		
	}
	
	
	@Then("^Order gets placed$")
	public void orderPlaced() throws InterruptedException {
		String[] orderAmountCaptured = orderAmount.split(" ");
		String[] finalResult = null;
		String placedOrderDetails = driver.findElement(By.xpath("/html/body/div[10]/p")).getText();
		System.out.println(placedOrderDetails);
		String[] split = placedOrderDetails.split("\n");
		for(String temp : split)
		{
			if(temp.contains("Amount"))
			{
				finalResult = temp.split(":");
				finalResult = finalResult[1].trim().split(" ");
			}
		}
		PlaceOrder.orderPlacedOkButton(driver).click();
		Assert.assertTrue(finalResult[0].equals(orderAmountCaptured[1]));
		driver.quit();
	}
}
