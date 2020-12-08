package base;

import org.openqa.selenium.WebDriver;

import webDrivers.Factory;
import webDrivers.WebDriverImpl;

public class TestContext {
	
	private static TestContext obj;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	private TestContext() {
		
	}
	
	public static TestContext getInstance() {
		if(obj == null) {
			obj = new TestContext();
		}
		
		return obj;
	}
	
	public final void setWebDriver(String browser) {
		WebDriverImpl impl = Factory.selectBrowser(browser);
		WebDriver driver = impl.getBrowserDriver();
		webDriver.set(driver);
	}
	
	public WebDriver getDriver() {
		return webDriver.get();
	}
	
	
	
}

