package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constant.Constant;

public class ScreenshotManager {
	
	private final static String screenshotFilePath = System.getProperty("user.dir").replace("\\", "/") +  Constant.screenshotFileDir + Constant.screenshotFileName;
	public static String captureScreenshot(WebDriver driver){
		driver.switchTo().defaultContent();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotFilePath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destFile.getAbsolutePath();
		
	}
	
}
