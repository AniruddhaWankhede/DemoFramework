package webDrivers;

/*
 * Class title: Factory.java
 * Description: This class is used to create WebDriver factory
 * Date Created: 08 December 2020 
 */

import constant.Constant;

public class Factory {
	
	public static WebDriverImpl selectBrowser(String browser) {
		WebDriverImpl impl = null;
		
		if(browser.equalsIgnoreCase(Constant.chromeBrowser)) {
			impl = new ChromeBrowser();
		} else if(browser.equalsIgnoreCase(Constant.ieBrowser)) {
			impl = new InternetExplorerBrowser();
		} else if(browser.equalsIgnoreCase(Constant.firefoxBrowser)) {
			impl = new FirefoxBrowser();
		}
		
		return impl;
	}
}
