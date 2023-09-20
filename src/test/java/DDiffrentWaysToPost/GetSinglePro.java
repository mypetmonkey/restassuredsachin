package DDiffrentWaysToPost;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSinglePro {
	@Test
	public void getsingle() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.get("/projects/TY_PROJ_5337")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1200l),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
