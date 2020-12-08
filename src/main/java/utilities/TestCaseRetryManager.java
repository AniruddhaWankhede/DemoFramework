package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import constant.Constant;

public class TestCaseRetryManager implements IRetryAnalyzer {

    private int count = 0;
    
    @Override
    public boolean retry(ITestResult iTestResult) {
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
