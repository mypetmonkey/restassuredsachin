package CRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;

public class PatchPro {
	@Test
	public void create() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		 JavaLiberary jlib=new JavaLiberary();
		 JSONObject jobj=new JSONObject();
		// HashMap<Object,Object> jobj=new HashMap<Object,Object>();
		 jobj.put("createdBy","Rajhans");
		 jobj.put("projectName", "OnlineBankg"+jlib.random());
		 jobj.put("status","inprogress");
		 jobj.put("teamSize", "10");
		 
		 given()
		 .body(jobj)
		 .contentType(ContentType.JSON)
         
		 .when()
		 .put("/projects/TY_PROJ_5060")
		 
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .contentType(ContentType.JSON)
		 .time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		 .log().all();
		 
	}
}
