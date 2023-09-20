package DDiffrentWaysToPost;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class postByFile {
	@Test
	public void create() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File f=new File(".\\src\\test\\resources\\raju.json");
		 
		given()
		.body(f)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
	    .then()
	    .assertThat()
        .statusCode(201)
        .contentType(ContentType.JSON)
        .time(Matchers.lessThan(1200l),TimeUnit.MILLISECONDS)
        .log().all();
        
	    
	}

}
