package Diffrentparameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void path() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.pathParam("pid", "TY_PROJ_5059")
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
		
	}
	

}
