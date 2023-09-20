package DDiffrentWaysToPost;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllPro {
	
	@Test
	public void getll() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.get("/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1200l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
