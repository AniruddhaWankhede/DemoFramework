package wrapper;

import io.restassured.response.Response;
import utilities.AssertManager;
import static io.restassured.RestAssured.*;
import java.util.List;
import java.util.Map;
import constant.Constant;

public class ApiActions {
	public Response httpGetRequest(String uri) {
		
		Response response = given().when().get(uri);
		
		if(response.statusCode() == Constant.httpStatusCodeOK) {
			return response;
		}else {
			AssertManager.assertFail("Not able to fulfill API GET Request. found status code : " + response.statusCode());
			return null;
		}
	}
	
	public List<String> readJsonListHTTPResponse(Response response, String node) {
		
		List<String> lsNodes = response.jsonPath().getList(node);
		
		return lsNodes;
	}
	
	public Map<String, String> readJsonMapHTTPResponse(Response response, String node) {
		
		Map<String, String> mapNodes = response.jsonPath().getMap(node);
		
		return mapNodes;
	}
}
