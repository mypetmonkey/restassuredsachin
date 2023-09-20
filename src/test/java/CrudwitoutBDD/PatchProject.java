
package CrudwitoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchProject {
	
	@Test
	public void patchproject() {
		JSONObject j=new JSONObject();
		//create the request  body
		j.put("createdBy","Raju");
		j.put("projectName","OnlineBankingSystemp");
		j.put("status", "progress");
		j.put("teamSize","22");
		
		
		RequestSpecification req=RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		
		//step 2  Perform the Action
		
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_3698");
		
	//	Step 3: Validate the response
		response.then().log().all();
		int stcode=response.getStatusCode();
		Assert.assertEquals(200, stcode);
//		System.out.println(response.getContentType());
//		System.out.println(response.asString());
//		System.out.println(response.asPrettyString());
//		System.out.println(response.statusCode());
		
	}

}
