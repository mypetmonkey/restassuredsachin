package Diffrentparameter;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static  io.restassured.RestAssured.*;

public class PathParamUpdate {
	
	@Test
	public void update() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
	given()
	.pathParam("createdBy", "Raju")
	.pathParam("projectName", "Bankingsystemtruist")
	.pathParam("status", "created")
	.pathParam("teamSize", 22 )
	.contentType(ContentType.JSON)
	
	.when()
	.put("/projects/TY_PROJ_5059")

    .then()
    .assertThat()
    .statusCode(200)
    .log().all();
	
	}

}
