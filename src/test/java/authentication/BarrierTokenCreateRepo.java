package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BarrierTokenCreateRepo {
	
	@Test
	public void barrierToken() {
		JavaLiberary jlib=new JavaLiberary();
		
		baseURI="https://api.github.com";
		JSONObject j=new JSONObject();
		j.put("name","restAssured"+jlib.random());
		
		given()
		.auth().oauth2("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")
		.body(j)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		.then().log().all();
	}

}
