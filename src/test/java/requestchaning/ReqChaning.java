 package requestchaning;

import org.testng.annotations.Test;

import Pojoclass.NewProChaning;
import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class ReqChaning {
@Test
public void chain() {
	JavaLiberary j=new JavaLiberary();
	
	NewProChaning np=new NewProChaning("Raju","BankInd"+j.random(),"created",13);
	
	baseURI="http://rmgtestingserver";
	port=8084;
	
	
	Response resp = given()
	.body(np)
	.contentType(ContentType.JSON)
	.post("/addProject");
	
	String proid = resp.jsonPath().get("projectId");
	System.out.println(proid);
	resp.then().log().all();
	
	//getting
	
	given()
	.pathParam("pid", proid)
	.when()
	.get("/projects/{pid}")
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	
	
	//updating
	NewProChaning np2=new NewProChaning("Raju","akshra","passed",33);
    
    given()
    .pathParam("pid", proid)
    .body(np2)
    .contentType(ContentType.JSON)
    
    .when()
    .put("/projects/{pid}")
    
    .then()
    .assertThat()
    .statusCode(200)
    .contentType(ContentType.JSON)
    .log().all();
	
    //deleting
	
	given()
	.pathParam("pid", proid)
	.when()
	.delete("/projects/{pid}")
	
	.then()
	.statusCode(204)
	.contentType(ContentType.JSON)
	.log().all();
	
	
}
}
