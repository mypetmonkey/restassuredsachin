package BodyResponseValidation;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;

public class DynamicResponseValidation2 {
	

	static boolean idChecker(List<String> list,String data) {
		for(String projectId:list) {
			if(projectId.equalsIgnoreCase(data))
				return true;
		}
		return false;
	}
	
	@Test
	public void dynamic() {
		baseURI="https://rmgtestingserver";
		port=8084;
		String expdata = "TY_PROJ_5555";
		
		Response resp=when()
				.get("/projects");
		  List<String> ids= resp.jsonPath().get("projectId");

		boolean b=idChecker(ids,expdata);
		if(b) 
			System.out.println("data verified");
		resp.then().log().all();
	}
	

}
