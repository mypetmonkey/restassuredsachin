package authentication;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class preemtiveAuth {
	
	@Test
	public void preemtive() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@99994")
		
		
		.when()
		.get("/login")
		
		.then().assertThat().log().all();
	}

}
