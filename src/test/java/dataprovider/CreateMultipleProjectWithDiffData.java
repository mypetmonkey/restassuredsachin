package dataprovider;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pojoclass.NewProChaning;
import genericutilities.JavaLiberary;
import io.restassured.http.ContentType;
import static  io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class CreateMultipleProjectWithDiffData {
	
	@DataProvider//(name="getData")
	public Object[][] data(){
		 Object [][]data=new Object[3][3];
		 
		 data[0][0]="shiva";
		 data[0][1]="Marketing";
		 data[0][2]="going on";
		 data[0][3]=5;
		 
		 data[1][0]="aasu";
		 data[1][1]="crm";
		 data[1][2]="created";
		 data[1][3]=4;
		 
		 data[2][0]="manju";
		 data[2][1]="shoping";
		 data[2][2]="created";
		 data[2][3]=4;
		 
		 data[3][0]="surya";
		 data[3][1]="food delevery";
		 data[3][2]="created";
		 data[3][3]=45;
		 
		 return data;
	}

	
	@Test(dataProvider = "data")
	public void createPro(String createdBy,String projectName,String status, int teamSize) {
		
		
		JavaLiberary j=new JavaLiberary();
		NewProChaning np=new NewProChaning(createdBy, projectName+j.random(), status, teamSize);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.body(np)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(1200l),TimeUnit.MILLISECONDS)
		.log().all();
		
		}

	
	
}
