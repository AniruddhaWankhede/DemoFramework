package wrapper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.TestContext;
import utilities.AssertManager;
import utilities.ScreenshotManager;

public class WebDriverActions {

	private WebDriver webdriver;
	
	public WebDriverActions() {
		
	}
	
	public WebDriverActions(WebDriver driver) {
		this.webdriver = driver;
	}
	
	public void click(WebElement element) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		try {
			element.click();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			throw new AssertionError(e.getMessage() + "\nScreenshot Path : " + shotPath);
		}
	}
	
	public void clear(WebElement element) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		try {
			element.clear();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			throw new AssertionError(e.getMessage() + "\nScreenshot Path : " + shotPath);
		}
	}
	
	public void sendKeys(WebElement element, String input) {
		WebDriver driver = TestContext.getInstance().getDriver();
		
		try {
			element.sendKeys(input);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String shotPath = ScreenshotManager.captureScreenshot(driver);
			throw new AssertionError(e.getMessage() + "\nScreenshot Path : " + shotPath);
		}
	}
	
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
