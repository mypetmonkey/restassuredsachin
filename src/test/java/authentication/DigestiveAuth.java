package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuth {
	
	@Test
	public void digest() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then().log().all();
	}

}
