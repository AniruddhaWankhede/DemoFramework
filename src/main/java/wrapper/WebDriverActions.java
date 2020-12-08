package wrapper;

/*
 * Class title: WebDriverActions.java
 * Description: This class contain custom WebDriver methods which require for wrapper actions 
 * Date Created: 08 December 2020 
 */

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.TestContext;
import utilities.AssertManager;
import utilities.ScreenshotManager;

public class WebDriverActions {

	// Variables declaration
	private WebDriver webdriver;
	
	// Default constructor
	public WebDriverActions() {
		
	}
	
	// Parameterized constructor
	public WebDriverActions(WebDriver driver) {
		this.webdriver = driver;
	}
	
	// This method is used to click on a WebElement and captures screenshot as well as throw an Exception for failed test.
	public void click(WebElement element) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		try {
			element.click();
		}catch (Exception e) {
			e.printStackTrace();
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			throw new AssertionError(e.getMessage() + "\nScreenshot Path : " + shotPath);
		}
	}
	
	// This method is used to clear text area and captures screenshot as well as throw an Exception for failed test.
	public void clear(WebElement element) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		try {
			element.clear();
		}catch (Exception e) {
			e.printStackTrace();
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			throw new AssertionError(e.getMessage() + "\nScreenshot Path : " + shotPath);
		}
	}
	
	// This method is used to send text in text area and captures screenshot as well as throw an Exception for failed test.
	public void sendKeys(WebElement element, String input) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		try {
			element.sendKeys(input);
		}catch (Exception e) {
			e.printStackTrace();
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			throw new AssertionError(e.getMessage() + "\nScreenshot Path : " + shotPath);
		}
	}
	
	// This method is used for tab switch
	public void navigateToTab(String tab, String pageTitle) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		driver.switchTo().defaultContent();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='application-main ']//ul//li[@class='d-flex']//a"));
		
		for(WebElement element : elements) {
			if(element.getText().contains(tab)) {
				click(element);
				AssertManager.assertTrue(driver.getTitle().equals(pageTitle), driver, "");
				break;
			}
		}
	}
}
