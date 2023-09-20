  package CrudwitoutBDD;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	@Test
	public void getAllProject() {
//		RequestSpecification req=RestAssured.given();
//		Response response = req.get("http://rmgtestingserver:8084/projects");
//		System.out.println(response.prettyPrint());
//	
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects");
		int stcode=resp.getStatusCode();
		Assert.assertEquals(200, stcode);
		//resp.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
		resp.then().log().all();

   }
}