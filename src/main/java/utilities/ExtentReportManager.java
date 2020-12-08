package utilities;

/*
 * Class title: ExtentReportManager.java
 * Description: This class is used to set Extent report entities
 * Date Created: 08 December 2020 
 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.observer.entity.ReportEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.TestBase;

public class ExtentReportManager {
	
	// Variables declaration
	private static ExtentReports extent;
	
	// This method is used to configure extent report
	public static ExtentReports getExtentReport(String filePath) {
		if(extent == null) {
			ExtentObserver<ReportEntity> observer = new ExtentSparkReporter(filePath);
			extent = new ExtentReports();
			extent.setSystemInfo("Host Name", System.getProperty("user.name"));
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Browser", TestBase.browser);
			extent.attachReporter(observer);
		}
		
		return extent;
	}
}
