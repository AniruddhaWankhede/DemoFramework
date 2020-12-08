package testPlans;

import java.util.Map;
import org.testng.annotations.Test;
import base.TestBase;
import base.TestContext;
import constant.Constant;
import module.api.repositories.ApiRepositoriesModule;
import utilities.AssertManager;

public class TestScenario extends TestBase {
	
	@Test
	public void verifyRepositoryDetails() {
		
		testStarted();
		
		webdriverActions.navigateToTab(Constant.repositoriesPage, Constant.repositoriesPageTitle);
		Map<String, String> actRepoDetailsMap = repositoriesModule.fetchRepoDetails();
		Map<String, String> expRepoDetailsMap = apiRepositoriesModule.fetchRepoDetailsAPI();
		
		AssertManager.assertTrue(actRepoDetailsMap.equals(expRepoDetailsMap), TestContext.getInstance().getDriver(), "Repository name and description verification failed.");
		Constant.logger.info("Successfully verified Repository names and description");
		
		testCompleted();
		
	}
}
