package module.api.repositories;

/*
 * Class title: ApiRepositoriesModule.java
 * Description: This class contain API requests which are categorized under Repositories tab
 * Date Created: 08 December 2020 
 */

import static io.restassured.RestAssured.baseURI;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import io.restassured.response.Response;
import wrapper.ApiActions;

public class ApiRepositoriesModule extends ApiActions {
	
	// This method is used to fetch repository names by rest API request
	public List<String> fetchRepoNamesAPI() {
		String uri = baseURI + "/orgs/django/repos";
		Response response = httpGetRequest(uri);
		List<String> lsRepoNames = readJsonListHTTPResponse(response, "name");
		return lsRepoNames;
	}
	
	// This method is used to fetch repository descriptions by rest API request
	public List<String> fetchRepoDescAPI() {
		String uri = baseURI + "/orgs/django/repos";
		Response response = httpGetRequest(uri);
		List<String> lsRepoDesc = readJsonListHTTPResponse(response, "description");
		return lsRepoDesc;
	}
	
	// This method is used to fetch repository details by rest API request
	public Map<String, String> fetchRepoDetailsAPI(){
		List<String> lsRepoNames = fetchRepoNamesAPI();
		List<String> lsRepoDesc = fetchRepoDescAPI();
		Map<String, String> mapRepoDetails = new TreeMap<String, String>();
		for(int counter = 0; counter < lsRepoNames.size(); counter++) {
			mapRepoDetails.put(lsRepoNames.get(counter), lsRepoDesc.get(counter));
		}
		
		return mapRepoDetails;
	}
}
