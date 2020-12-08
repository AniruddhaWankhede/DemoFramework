package base;

/*
 * Class title: TestBase.java
 * Description: This is a base class and it is used for initial setup which require for test execution.
 * Date Created: 08 December 2020 
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentReportListener;
import module.api.repositories.ApiRepositoriesModule;
import module.repositories.RepositoriesModule;
import utilities.AssertManager;
import wrapper.ApiActions;
import wrapper.WebDriverActions;
import static io.restassured.RestAssured.*;

@Listeners(value = {ExtentReportListener.class})
public class TestBase {
	
	// Variables declaration
	public static String url;
	public static String apiURI;
	public static String browser;
	public static int timeout;
	protected WebDriverActions webdriverActions;
	protected RepositoriesModule repositoriesModule;
	protected ApiActions apiActions;
	protected ApiRepositoriesModule apiRepositoriesModule;
	
	
	// Annotated method will run once before test suite execution starts
	// This method is used for initial setup
	@BeforeSuite
	public void initialSetup() throws IOException{
		
		// Load data from config.properties file
		InputStream inStream = getClass().getClassLoader().getResourceAsStream(Constant.configPropertiesPath);
	    Properties prop = new Properties();  
	    prop.load(inStream);
	    
	    // Instantiate module instances
	    initModules();
	    
	    // Setting up browser
	    initBrowser(prop);
	    
	    // Setting up URL
	    initURL(prop);
	    
	    // Setting up Api URI
	    initApiUri(prop);
	    
	    // Setting up timeout
	    timeout = Integer.parseInt(prop.getProperty("timeout"));
	}
	
	// Annotated method will run before test case execution starts
	// This method is used to instantiate WebDriver instance
	@BeforeMethod
	public void browserNavigation() {
		
		// Instantiate WebDriver instance
		TestContext.getInstance().setWebDriver(browser);
		WebDriver driver = TestContext.getInstance().getDriver();
		Constant.logger.info("Successfully Instantiated Webdriver");
		
		// Navigate to URL and verify WebPage title
		driver.get(url);
		AssertManager.assertTrue(driver.getTitle().equals(Constant.repositoriesPageTitle), driver, "Not able to navigate to URL");
		Constant.logger.info("Successfully Navigated to URL : " + url);
		
		// Apply implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
		// Maximize browser window
		driver.manage().window().maximize();
	}
	
	// Annotated method will run after test case execution ends
	// This method is used to remove WebDriver instance
	@AfterMethod(alwaysRun = true)
	public void terminateBrowser() {
		TestContext.getInstance().removeDriver();
		Constant.logger.info("Successfully terminated webdriver");
	}
	
	// This method is used to setup Browser
	public void initBrowser(Properties prop) {
		
		if(System.getProperty("browser") != null && !System.getProperty("browser").equals("")) {
			browser = System.getProperty("browser");
		} else {
			browser = prop.getProperty("browser");
		}
		
		if(browser.equalsIgnoreCase(Constant.chromeBrowser)) {
	    	WebDriverManager.chromedriver().setup();
	    } else if(browser.equalsIgnoreCase(Constant.ieBrowser)) {
	    	WebDriverManager.iedriver().setup();
	    } else if(browser.equalsIgnoreCase(Constant.firefoxBrowser)) {
	    	WebDriverManager.firefoxdriver().setup();
	    }
	}
	
	// This method is used to setup URL
	public void initURL(Properties prop) {
		if(System.getProperty("url") != null && !System.getProperty("url").equals("")) {
			url = System.getProperty("url");
		} else {
			url = prop.getProperty("url");
		}
	}
	
	// This method is used to setup Api URI
	public void initApiUri(Properties prop) {
		if(System.getProperty("apiuri") != null && !System.getProperty("apiuri").equals("")) {
			apiURI = System.getProperty("apiuri");
		} else {
			apiURI = prop.getProperty("apiuri");
		}
		baseURI = apiURI;
	}
	
	// This method is used to instantiate module instances
	public void initModules() {
		webdriverActions = new WebDriverActions();
		repositoriesModule = new RepositoriesModule();
		apiActions = new ApiActions();
		apiRepositoriesModule = new ApiRepositoriesModule();
	}
	
	// This method informs about test case execution started
	public void testStarted() {
		Constant.logger.info("Test case execution started.");
	}
	
	// This method informs about test case execution completed
	public void testCompleted() {
		Constant.logger.info("Test case execution completed");
	}
	
}
