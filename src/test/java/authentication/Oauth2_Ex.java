package authentication;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Oauth2_Ex {
	
	@Test
	public void oauth() {
		
		Response resp = given()
		.formParam("client_id","mytrip")
		.formParam("client_secret", "dd91dbe09b61f9eec3c2dbd9745d414b")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		
//  capture the access token from the response of the above request
		
		String token=resp.jsonPath().get("access_token");
		System.out.println(token);
		
		
		//create another request and use the token to access the apis
		
		given()
		.auth().oauth2(token)
		.pathParam("user_id", 4512)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{user_id}/eggs-count")
		
		.then()
		.log().all();
		
	}

}
