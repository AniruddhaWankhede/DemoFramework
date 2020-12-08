package utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.observer.entity.ReportEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.TestBase;

public class ExtentReportManager {
	private static ExtentReports extent;
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
