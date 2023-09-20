      package CrudwitoutBDD;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.JavaLiberary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void create() {
		JavaLiberary jlib=new JavaLiberary();
		JSONObject j=new JSONObject();
		//HashMap j=new HashMap();
		//create the request  body
		j.put("createdBy","Raju");
		j.put("projectName","OnlineBankingSystem"+jlib.random());
		j.put("status", "created");
		j.put("teamSize","19");
		
		RequestSpecification req=RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		
		//step 2  Perform the Action
		
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
	//	Step 3: Validate the response
		
		int stcode=response.getStatusCode();
		Assert.assertEquals(201,stcode);
		response.then().log().all();
//		System.out.println(response.getContentType());
//		System.out.println(response.asString());
//		System.out.println(response.asPrettyString());
//		System.out.println(response.statusCode());
//		
	}

}
