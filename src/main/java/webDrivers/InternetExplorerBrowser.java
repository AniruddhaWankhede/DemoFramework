package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class InternetExplorerBrowser implements WebDriverImpl {

	@Override
	public WebDriver getBrowserDriver() {
		// TODO Auto-generated method stub
		return new InternetExplorerDriver();
	}

}
