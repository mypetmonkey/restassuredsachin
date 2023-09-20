package CrudwitoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericutilities.JavaLiberary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RequestChaning {
	String createuriwithend="http://rmgtestingserver:8084/projects";
	String getAllpro="http://rmgtestingserver:8084/projects";
	String getsinglepro="http://rmgtestingserver:8084/projects/";
	@Test
	public void reqchain() {
		JavaLiberary jlib=new JavaLiberary();
		JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy", "Rajhans");
		jobj.put("projectName", "OBS"+jlib.random());
		jobj.put("status", "created");
		jobj.put("teamSize", "10");
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response resp= req.post(createuriwithend);
		
		req.then().log().all();
		int stcode=resp.getStatusCode();
		Assert.assertEquals(200, stcode);
		
	}
//	@Test
//	public void getAllPro() {
//		Response resp = RestAssured.get(getAllpro);
//		resp.then().log().all();
//		int stcode=resp.getStatusCode();
//		Assert.assertEquals(200, stcode);
//}
	
	@Test
	public void getSinglepro() {
		Response resp = RestAssured.get(getsinglepro+"TY_PROJ_3643");
		resp.then().log().all();
		int stcode=resp.getStatusCode();
		Assert.assertEquals(200, stcode);
	}
		
	}


