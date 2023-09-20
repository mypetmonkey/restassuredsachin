 package CrudwitoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getSingleProject {
	
	@Test
	public void getSinglePro() {
	Response resp = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_3648");
	resp.then().log().all();
	int stcode=resp.getStatusCode();
	Assert.assertEquals(200, stcode);
		
	}

}
