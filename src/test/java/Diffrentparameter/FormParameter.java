package Diffrentparameter;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	public void form() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
	given()
	.formParam("createdBy", "Raju")
	.formParam("projectName", "Bankingsyss")
	.formParam("status", "created")
	.formParam("teamSize", 22 )
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
		
	}

}
