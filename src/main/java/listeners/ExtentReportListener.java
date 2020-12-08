package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constant.Constant;
import utilities.ExtentReportManager;

public class ExtentReportListener implements ITestListener{
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private static ExtentReports extent;
	
	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReportManager.getExtentReport(System.getProperty("user.dir").replace("\\", "/") + Constant.extentReportFilePath);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String[] resultArr = result.getTestClass().getName().split("\\.");
		String className = resultArr[resultArr.length - 1];
		String testCase = result.getMethod().getMethodName();
		// TODO Auto-generated method stub
		extentTest.set(extent.createTest(className + " > " + testCase).assignCategory(className));
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().info("Result Status: " + result.getStatus());
		extentTest.get().pass(String.valueOf(Status.PASS));
		extent.flush();
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().info("Result Status: " + result.getStatus());
		extentTest.get().fail(String.valueOf(Status.FAIL));
		extentTest.get().fail(result.getThrowable());
		extent.flush();
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.get().skip("Result Status: " + result.getStatus());
		extentTest.get().log(Status.SKIP, result.getThrowable());
		extent.flush();
	}
	
	
}
