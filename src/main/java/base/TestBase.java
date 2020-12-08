package base;

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
import wrapper.ApiActions;
import wrapper.WebDriverActions;
import static io.restassured.RestAssured.*;

@Listeners(value = {ExtentReportListener.class})
public class TestBase {

	public static String url;
	public static String apiURI;
	public static String browser;
	public static int timeout;
	protected WebDriverActions webdriverActions;
	protected RepositoriesModule repositoriesModule;
	protected ApiActions apiActions;
	protected ApiRepositoriesModule apiRepositoriesModule;
	
	@BeforeSuite(alwaysRun = true)
	public void initialSetup() throws IOException{
		InputStream inStream = getClass().getClassLoader().getResourceAsStream(Constant.configPropertiesPath);
	    Properties prop = new Properties();  
	    prop.load(inStream);
		
	    url = prop.getProperty("url");
	    browser = prop.getProperty("browser");
	    apiURI = prop.getProperty("apiuri");
	    baseURI = apiURI;
	    timeout = Integer.parseInt(prop.getProperty("timeout"));
	    initModules();
	    initBrowser(browser);
	    
	    
	}
	
	@BeforeMethod(alwaysRun = true)
	public void browserNavigation() {
		TestContext.getInstance().setWebDriver(browser);
		WebDriver driver = TestContext.getInstance().getDriver();
		Constant.logger.info("Successfully Instantiated Webdriver");
		driver.get(url);
		Constant.logger.info("Successfully Navigated to URL : " + url);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void terminateBrowser() {
		TestContext.getInstance().getDriver().close();
		Constant.logger.info("Successfully terminated webdriver");
	}
	
	public void initBrowser(String browser) {
		if(browser.equalsIgnoreCase(Constant.chromeBrowser)) {
	    	WebDriverManager.chromedriver().setup();
	    } else if(browser.equalsIgnoreCase(Constant.ieBrowser)) {
	    	WebDriverManager.iedriver().setup();
	    } else if(browser.equalsIgnoreCase(Constant.firefoxBrowser)) {
	    	WebDriverManager.firefoxdriver().setup();
	    }
	}
	
	public void initModules() {
		webdriverActions = new WebDriverActions();
		repositoriesModule = new RepositoriesModule();
		apiActions = new ApiActions();
		apiRepositoriesModule = new ApiRepositoriesModule();
	}
	
	public void testStarted() {
		Constant.logger.info("Test case execution started.");
	}
	
	public void testCompleted() {
		Constant.logger.info("Test case execution completed");
	}
	
}
