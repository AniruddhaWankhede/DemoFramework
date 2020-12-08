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

	// Annotated method is used for re-execution of failed tests considering retry count
    @Override
    public boolean retry(ITestResult iTestResult) {
    	int count = 0;
    	if (!iTestResult.isSuccess()) {                      
            if (count < Constant.default_retry_count) {                            
                count++;                                     
                iTestResult.setStatus(ITestResult.FAILURE);
                iTestResult.getMethod().setInvocationCount(iTestResult.getMethod().getInvocationCount() + 1);
                
                return true;                                 
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      
        }
        
        return false;
    }
}
