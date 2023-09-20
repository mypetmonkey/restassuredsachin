   package BodyResponseValidation;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import junit.framework.Assert;
 import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	@Test
	public void StaticResp() {
		String exData="TY_PROJ_3631";
		baseURI="http://rmgtestingserver";
		port=8084;
		Response resp = when()
				.get("/projects");
				
		String acData=resp.jsonPath().get("[0].projectId");
		
		Assert.assertEquals(exData, acData);
		System.out.println("data verified");
		resp.then().log().all();
	}

}
