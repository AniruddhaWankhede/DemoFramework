package testPlans;

/*
 * Class title: TestScenario.java
 * Description: This class is used to test a scenario
 * Feature:  Verification of UI Repository names and description with API response 
 * Date Created: 08 December 2020 
 */

import java.util.Map;
import org.testng.annotations.Test;
import base.TestBase;
import base.TestContext;
import constant.Constant;
import utilities.AssertManager;
import utilities.TestCaseRetryManager;

public class TestScenario extends TestBase {
	
	@Test(enabled = true, retryAnalyzer = TestCaseRetryManager.class)
	public void verifyRepositoryDetails() {
		
		testStarted();
		
		// Navigate to 'Repositories' tab
		webdriverActions.navigateToTab(Constant.repositoriesPage, Constant.repositoriesPageTitle);
		
		// Fetch UI repository details
		Map<String, String> actRepoDetailsMap = repositoriesModule.fetchRepoDetails();

		// Fetch API repository details
		Map<String, String> expRepoDetailsMap = apiRepositoriesModule.fetchRepoDetailsAPI();
		
		// Verify UI repository details with API repository details
		AssertManager.assertTrue(actRepoDetailsMap.equals(expRepoDetailsMap), TestContext.getInstance().getDriver(), "Repository name and description verification failed.");
		Constant.logger.info("Successfully verified Repository names and description with expected API data.");
		
		testCompleted();
		
	}
}
