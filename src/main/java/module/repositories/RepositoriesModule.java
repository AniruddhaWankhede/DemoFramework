package module.repositories;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.TestContext;
import constant.Constant;
import wrapper.WebDriverActions;

public class RepositoriesModule extends WebDriverActions{
	public RepositoriesModule() {
		
	}
	
	public RepositoriesModule(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> fetchRepoDetails(){
		Map<String, String> repoDetailsMap = new TreeMap<String, String>();
		List<String> lsRepoNames = fetchRepoNames();
		List<String> lsRepoDesc = fetchRepoDesc();
		
		for(int counter = 0; counter < lsRepoNames.size(); counter++) {
			repoDetailsMap.put(lsRepoNames.get(counter), lsRepoDesc.get(counter));
		}
		
		return repoDetailsMap;
	}
	
	public List<String> fetchRepoNames(){
		WebDriver driver = TestContext.getInstance().getDriver();
		List<WebElement> elements = driver.findElements(By.xpath(Constant.repoPanelXpath));
		List<String> lsRepoNames = new ArrayList<String>();
		String repoName = "";
		for(WebElement element : elements) {
			repoName = element.findElement(By.xpath("h3/a")).getText().trim();
			lsRepoNames.add(repoName);
			Constant.logger.info("Repository name '" + repoName + "' has been added to a list");
		}
		
		return lsRepoNames;
	}
	
	public List<String> fetchRepoDesc(){
		WebDriver driver = TestContext.getInstance().getDriver();
		List<WebElement> elements = driver.findElements(By.xpath(Constant.repoPanelXpath));
		List<String> lsRepoDesc = new ArrayList<String>();
		String repoDesc = "";
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
