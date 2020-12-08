package module.repositories;

/*
 * Class title: RepositoriesModule.java
 * Description: This class contain actions which are categorized under Repositories tab
 * Date Created: 08 December 2020 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.TestContext;
import constant.Constant;
import wrapper.WebDriverActions;

public class RepositoriesModule extends WebDriverActions{
	
	// Default Constructor
	public RepositoriesModule() {
		
	}
	
	// Parameterized Constructor
	public RepositoriesModule(WebDriver driver) {
		super(driver);
	}
	
	// This method is used to fetch Repository names and descriptions
	public Map<String, String> fetchRepoDetails(){
		
		// Variable declaration
		Map<String, String> repoDetailsMap = new TreeMap<String, String>();
		List<String> lsRepoNames = fetchRepoNames();
		List<String> lsRepoDesc = fetchRepoDesc();
		
		// Inserting values in a tree map so that repository names will be in alphabetical order
		for(int counter = 0; counter < lsRepoNames.size(); counter++) {
			repoDetailsMap.put(lsRepoNames.get(counter), lsRepoDesc.get(counter));
		}
		
		return repoDetailsMap;
	}
	
	// This method is used to fetch Repository names
	public List<String> fetchRepoNames(){
		
		// Variable declaration
		WebDriver driver = TestContext.getInstance().getDriver();
		List<WebElement> elements = driver.findElements(By.xpath(Constant.repoPanelXpath));
		List<String> lsRepoNames = new ArrayList<String>();
		String repoName = "";
		
		// Inserting repository names to a list
		for(WebElement element : elements) {
			repoName = element.findElement(By.xpath("h3/a")).getText().trim();
			lsRepoNames.add(repoName);
			Constant.logger.info("Repository name '" + repoName + "' has been added to a list");
		}
		
		return lsRepoNames;
	}
	
	// This method is used fetch repository descriptions
	public List<String> fetchRepoDesc(){
		
		// Variable declaration
		WebDriver driver = TestContext.getInstance().getDriver();
		List<WebElement> elements = driver.findElements(By.xpath(Constant.repoPanelXpath));
		List<String> lsRepoDesc = new ArrayList<String>();
		String repoDesc = "";
		
		// Inserting repository description to a list
		for(WebElement element : elements) {
			try {
				repoDesc = element.findElement(By.xpath("p")).getText().trim();
			}catch (Exception e) {
				// TODO: handle exception
				repoDesc = null;
			}
			lsRepoDesc.add(repoDesc);
			Constant.logger.info("Repository description '" + repoDesc + "' has been added to a list");
		}
		
		return lsRepoDesc;
	}
	
}
