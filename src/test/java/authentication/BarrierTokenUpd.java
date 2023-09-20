package authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class BarrierTokenUpd {
	
	@Test
	public void btokenUpd() {
		
		baseURI="https://api.github.com";
		
		JSONObject jobj= new JSONObject();
		jobj.put("name", "restAssured-47");
		
		given()
		.auth().oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.patch("/repos/mypetmonkey/restAssured")
		
	    .then()
	    .assertThat()
	    .statusCode(200)
	    .time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
	    .log().all();
		
		
	}

}
