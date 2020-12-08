package webDrivers;

/*
 * Class title: InternetExplorerBrowser.java
 * Description: This class is used to instantiate Internet Explorer WebDriver instance 
 * Date Created: 08 December 2020 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerBrowser implements WebDriverImpl {

	@Override
	public WebDriver getBrowserDriver() {
		return new InternetExplorerDriver();
	}

}
