package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements WebDriverImpl {

	@Override
	public WebDriver getBrowserDriver() {
		// TODO Auto-generated method stub
		return new ChromeDriver();
	}

}
