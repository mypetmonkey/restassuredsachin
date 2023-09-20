package DDiffrentWaysToPost;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import Pojoclass.NewProject;
import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostByPojo {
	
	@Test
	public void create() {
		JavaLiberary j=new JavaLiberary();
		baseURI="http://rmgtestingserver";
		port=8084;
		NewProject np=new NewProject("Raju","Bankingus"+j.random(),"going on",22);
		 
		given()
		.body(np)
		.contentType(ContentType.JSON)
		
		.when()  
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1200l),TimeUnit.MILLISECONDS)
	    .log().all();
	        
		
	}

}
