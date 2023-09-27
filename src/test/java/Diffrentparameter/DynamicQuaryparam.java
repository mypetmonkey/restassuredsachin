package Diffrentparameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

import java.util.Random;

public class DynamicQuaryparam {
	
	@Test
	public void test() {
		int qvalue=DynamicQuaryparam.getRandom(30000000);
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body("")
		.queryParam("name", qvalue);
		
				
		
		
	}
	
	
	public static int getRandom(int boundry) {
		Random ran=new Random();
		int random = ran.nextInt(boundry);
		return random;
	}

}
