    package CRUDwithBDD;


import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class CreateProject {

	@Test
	public void create() {
		baseURI="http://rmgtestingserver";
		port=8084;
		 JavaLiberary jlib=new JavaLiberary();
		 JSONObject jobj=new JSONObject();
		 jobj.put("createdBy","Rajhans");
		 jobj.put("projectName", "OnlineBank"+jlib.random());
		 jobj.put("status","inprogress");
		 jobj.put("teamSize", "10");
		 
		 given()
		 .body(jobj)
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
