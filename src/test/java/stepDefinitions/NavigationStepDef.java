package stepDefinitions;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CategoriesObject;
import utils.Base;


public class NavigationStepDef extends Base{
	static Logger log = Logger.getLogger(Log.class.getClass());
	String log4jConfPath = "log4j.properties";
	WebDriver driver;
	
	public NavigationStepDef() throws Exception
	{
		
		PropertyConfigurator.configure(log4jConfPath);
		driver = init();
	}

	@Given("^DemoBlaze is available$")
	public void demoBlazeIsAvailable() throws Exception {
		log.info("Checking if DemoBlaze is available..");
		WebElement element = CategoriesObject.categoryLaptops(driver);
		Assert.assertTrue(element.isDisplayed());
		
	}

	@When("^User clicks \"(.*)\" menu item$")
	public void openNavigationMenuItem(String navigationMenuItem) {
		driver.navigate().to(Constants.BASE_URL);
		if(navigationMenuItem.equals("Laptops"))
		{
			CategoriesObject.categoryLaptops(driver).click();
		}
		else if(navigationMenuItem.equals("Monitors"))
		{
			CategoriesObject.categoryMonitors(driver).click();
		}
		else if(navigationMenuItem.equals("Phones"))
		{
			CategoriesObject.categoryPhones(driver).click();
		}
	}
	
	@Then("^\"(.*)\" page is opened$")
	public void isPageOpened(String navigationMenuItem) {
		boolean flag = false;
		if(navigationMenuItem.equals("Laptops"))
		{
			flag = driver.findElements(By.partialLinkText("Sony vaio")).size() > 0;
		}
		else if(navigationMenuItem.equals("Monitors"))
		{
			flag = driver.findElements(By.partialLinkText("Apple monitor")).size() > 0;
		}
		else if(navigationMenuItem.equals("Phones"))
		{
			flag = driver.findElements(By.partialLinkText("Samsung galaxy")).size() > 0;
		}
		Assert.assertTrue(flag);
		driver.quit();
	}

}
