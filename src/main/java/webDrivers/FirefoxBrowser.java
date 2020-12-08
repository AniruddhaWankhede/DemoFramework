package webDrivers;

/*
 * Class title: FirefoxBrowser.java
 * Description: This class is used to instantiate Firefox WebDriver instance 
 * Date Created: 08 December 2020 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements WebDriverImpl {

	@Override
	public WebDriver getBrowserDriver() {
		return new FirefoxDriver();
	}

}
