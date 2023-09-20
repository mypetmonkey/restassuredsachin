package Diffrentparameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QuaryParameter {
	
	@Test
	public void quary() {
		baseURI="https://reqres.in";
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.log().all();
	}

}
