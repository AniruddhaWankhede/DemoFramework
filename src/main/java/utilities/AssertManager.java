package utilities;

/*
 * Class title: AssertManager.java
 * Description: This class contain custom Assertion methods which will throw an exception for failed tests and will capture screenshot 
 * Date Created: 08 December 2020 
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constant.Constant;

public class AssertManager {
	public static void assertTrue(boolean flag, WebDriver driver, String message) {
		try {
		Assert.assertTrue(flag, message);
		}catch (AssertionError e) {
			// Capture screenshot for failed scenario
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			Constant.logger.error("Assertion Error: Expected true, but get " + flag + ", screenshot Address: " + shotPath);
			throw new AssertionError();
		}
	}
	
	public static void assertFalse(boolean flag, WebDriver driver, String message) {
		
		try {
			Assert.assertFalse(flag, message);
		}catch (AssertionError e) {
			// Capture screenshot for failed scenario
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			Constant.logger.error("Assertion Error: Expected false, but get " + flag + ", screenshot Address: " + shotPath);
			throw new AssertionError();
		}
	}
	
	public static void assertFail(String message) {
		throw new AssertionError(message);
	}
}
