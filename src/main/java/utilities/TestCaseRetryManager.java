package utilities;

/*
 * Class title: TestCaseRetryManager.java
 * Description: This class is used for re-execution of failed tests considering retry count with the help of IRetryAnalyzer interface
 * Date Created: 08 December 2020 
 */

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import constant.Constant;

public class TestCaseRetryManager implements IRetryAnalyzer {

	private static int count = 0;
	// Annotated method is used for re-execution of failed tests considering retry count
    @Override
    public boolean retry(ITestResult iTestResult) {
    	
    	if (!iTestResult.isSuccess()) {                      
            if (count < Constant.default_retry_count) {                            
                count++;                                     
                iTestResult.setStatus(ITestResult.SKIP);
                return true;                                 
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      
        }
    	
    	iTestResult.getMethod().setInvocationCount(iTestResult.getMethod().getInvocationCount() + 1);
        return false;
    }
}
