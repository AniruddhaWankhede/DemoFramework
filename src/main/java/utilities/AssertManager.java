package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constant.Constant;

public class AssertManager {
	
	public static void assertTrue(boolean flag, WebDriver driver, String errorMessage) {
		
		try {
			Assert.assertTrue(flag, errorMessage);
		}catch (Exception e) {
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			Constant.logger.error("Assertion Error: Expected true, but get " + flag + ", screenshot Address: " + shotPath);
		}
	}
	
	public static void assertFalse(boolean flag, WebDriver driver, String errorMessage) {
		
		try {
			Assert.assertFalse(flag, errorMessage);
		}catch (Exception e) {
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			Constant.logger.error("Assertion Error: Expected false, but get " + flag + ", screenshot Address: " + shotPath);
		}
	}
	
	public static void assertFail(String message) {
		throw new AssertionError(message);
	}
}
