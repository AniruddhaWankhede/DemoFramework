package wrapper;

/*
 * Class title: ApiActions.java
 * Description: This class contain custom API methods which require for wrapper actions 
 * Date Created: 08 December 2020 
 */

import io.restassured.response.Response;
import utilities.AssertManager;
import static io.restassured.RestAssured.*;
import java.util.List;
import java.util.Map;
import constant.Constant;

public class ApiActions {
	
	// This method is used to send GET Request by taking URI as a parameter
	public Response httpGetRequest(String uri) {
		
		Response response = given().when().get(uri);
		
		if(response.statusCode() == Constant.httpStatusCodeOK) {
			return response;
		}else {
			AssertManager.assertFail("Not able to fulfill API GET Request. found status code : " + response.statusCode());
			return null;
		}
	}
	
	// This method is used to read JSON response in List format
	public List<String> readJsonListHTTPResponse(Response response, String node) {
		
		List<String> lsNodes = response.jsonPath().getList(node);
		
		return lsNodes;
	}
	
	// This method is used to read JSON response in Map format
	public Map<String, String> readJsonMapHTTPResponse(Response response, String node) {
		
		Map<String, String> mapNodes = response.jsonPath().getMap(node);
		
		return mapNodes;
	}
}
