   package BodyResponseValidation;

import org.junit.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;

public class DynamicResponseValidation {
	
	@Test
	public void dynamic() {
		baseURI="http://rmgtestingserver";
		port=8084;
		String expData="TY_PROJ_5570";
		
		Response resp=when()
				.get("/projects");
		
		boolean flag=false;
	  List<String> ids= resp.jsonPath().get("projectId");
		for(String projectId:ids) {
			if(projectId.equalsIgnoreCase(expData))
				flag=true;
		}
		
		
		Assert.assertTrue(flag);
		System.out.println("data verified");
		resp.then().log().all();
	}

}
