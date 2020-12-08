package utilities;

/*
 * Class title: ScreenshotManager.java
 * Description: This class is used to capture screenshot for failed tests and store a JPEG file in specified folder
 * Date Created: 08 December 2020 
 */

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import constant.Constant;

public class ScreenshotManager {
	
	// Variables declaration
	private final static String screenshotFilePath = System.getProperty("user.dir").replace("\\", "/") +  Constant.screenshotFileDir + Constant.screenshotFileName;
	
	// This method is used to capture screenshot for failed tests and store a JPEG file in specified folder
	public static String captureScreenshot(WebDriver driver){
		driver.switchTo().defaultContent();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotFilePath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destFile.getAbsolutePath();
		
	}
	
}
