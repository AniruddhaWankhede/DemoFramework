package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements WebDriverImpl {

	@Override
	public WebDriver getBrowserDriver() {
		// TODO Auto-generated method stub
		return new FirefoxDriver();
	}

}
