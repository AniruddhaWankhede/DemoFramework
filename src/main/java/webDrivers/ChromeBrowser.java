package webDrivers;

/*
 * Class title: ChromeBrowser.java
 * Description: This class is used to instantiate Google Chrome WebDriver instance 
 * Date Created: 08 December 2020 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements WebDriverImpl {

	@Override
	public WebDriver getBrowserDriver() {
		return new ChromeDriver();
	}

}
