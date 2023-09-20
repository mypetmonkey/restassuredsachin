package DDiffrentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;

public class CreateProHashmap {

	
	@Test
	public void create() {
		baseURI="http://rmgtestingserver";
		port=8084;
		 JavaLiberary jlib=new JavaLiberary();
		 HashMap<Object,Object> hm=new HashMap<Object, Object>();
		 hm.put("createdBy","Rastogi");
		 hm.put("projectName", "OnlineBankUS"+jlib.random());
		 hm.put("status","inprogress");
		 hm.put("teamSize", "12");
		 
		 given()
		 .body(hm)
		 .contentType(ContentType.JSON)
         
		 .when()
		 .post("/addProject")
		 
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .contentType(ContentType.JSON)
		 .time(Matchers.lessThan(2000l ),TimeUnit.MILLISECONDS)
		 .log().all();
	} 
}
