package base;

/*
 * Class title: TestContext.java
 * Description: This class is used for creating multiple instances of WebDriver which require to execute 
 * tests in Parallel. Here, Singleton design pattern is used.
 * Date Created: 08 December 2020 
 */

import org.openqa.selenium.WebDriver;
import webDrivers.Factory;
import webDrivers.WebDriverImpl;

public class TestContext {
	
	// Variables declaration
	private static TestContext obj;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	// Private constructor to create class instance inside this class only
	private TestContext() {
		
	}
	
	// Static method which will get called everywhere to get class instance
	public static TestContext getInstance() {
		if(obj == null) {
			obj = new TestContext();
		}
		
		return obj;
	}
	
	// This method is used to set ThreadLocal of WebDrivers using Factory method design pattern
	public final void setWebDriver(String browser) {
		WebDriverImpl impl = Factory.selectBrowser(browser);
		WebDriver driver = impl.getBrowserDriver();
		webDriver.set(driver);
	}
	
	// This method is used to get WebDriver instance from ThreadLocal of WebDriver
	public WebDriver getDriver() {
		return webDriver.get();
	}
	
	// This method is used to remove WebDriver instance from ThreadLocal of WebDriver
	public void removeDriver() {
		try {
			webDriver.get().quit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		webDriver.remove();
	}
}

