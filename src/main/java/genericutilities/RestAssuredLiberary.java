package genericutilities;

import io.restassured.response.Response;

public class RestAssuredLiberary {
	
	public String getJsonData(Response  response,String path) {
		String jsonData=response.jsonPath().get(path);
		return jsonData;
	}

}
 