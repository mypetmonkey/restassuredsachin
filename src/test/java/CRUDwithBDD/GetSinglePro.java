package CRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class GetSinglePro {
	@Test
	public void getSingle() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		 when()
		 .get("/projects/TY_PROJ_5123")
		 
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .contentType(ContentType.JSON)
		 .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		 .log().all();
	}

}
