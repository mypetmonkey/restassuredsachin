package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import java.util.concurrent.TimeUnit;
public class DeletePro {
	@Test
	public void delete() {
		RestAssured r=new RestAssured();
		r.baseURI="http://rmgtestingserver";
		r.port=8084;
		
		r.when()
		.delete("/projects/TY_PROJ_5060")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
