package module.api.repositories;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.restassured.response.Response;
import wrapper.ApiActions;

public class ApiRepositoriesModule extends ApiActions {
	
	public List<String> fetchRepoNamesAPI() {
		String uri = baseURI + "/orgs/django/repos";
		Response response = httpGetRequest(uri);
		List<String> lsRepoNames = readJsonListHTTPResponse(response, "name");
		return lsRepoNames;
	}
	
	public List<String> fetchRepoDescAPI() {
		String uri = baseURI + "/orgs/django/repos";
		Response response = httpGetRequest(uri);
		List<String> lsRepoDesc = readJsonListHTTPResponse(response, "description");
		return lsRepoDesc;
	}
	
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
