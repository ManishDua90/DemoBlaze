package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import common.Constants;

public class Base {
    protected static WebDriver driver = null;

    public static final String baseUrl = Constants.BASE_URL;
 
    public WebDriver init() throws Exception {
        return setupDriver();
    }


    private WebDriver setupDriver() throws Exception {
    	System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
