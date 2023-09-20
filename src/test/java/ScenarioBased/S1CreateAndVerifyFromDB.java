package ScenarioBased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pojoclass.NewProject;
import genericutilities.BaseClass;
import genericutilities.DatabaseLiberary;
import genericutilities.EndPointLiberary;
import genericutilities.Iconstant;
import genericutilities.JavaLiberary;
import genericutilities.RestAssuredLiberary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class S1CreateAndVerifyFromDB extends BaseClass implements Iconstant,EndPointLiberary {
	JavaLiberary j=new JavaLiberary();
	
	
	@Test
	public void createPro() throws SQLException, InterruptedException {
		NewProject np=new NewProject("Rajhans","bankingOBS"+j.random(), "ongoing", 24);
		RestAssuredLiberary rlib=new RestAssuredLiberary();
		Response res = given()
		.spec(reqst)
		.body(np)
		.contentType(ContentType.JSON)
		
		.when()
		.post(createProject);
		
		String proid=rlib.getJsonData(res, "projectId");
		System.out.println(proid);
		res.then().log().all();
		
		given()
		.pathParams("pid",proid)
		.auth().basic(dbun, dbpwd)
		
		.when().get("/projects/{pid}")
		.then().log().all();
		
		//validate in database
		
		DatabaseLiberary dlib=new DatabaseLiberary();
		dlib.connectToDB();
		String quary="select * from project;";
		dlib.readDataFromDBAndValidate(quary, 1, proid);
		dlib.closeDB();
		
		//validating in gui
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http:/rmgtestingserver:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys(appUserName);
		driver.findElement(By.id("inputPassword")).sendKeys(appPwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li/a[.='Projects']")).click();
		String actual=driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		
		if(actual.equals(proid)) {
			System.out.println("data verified, available");
		}
		else {
			System.out.println("not present");
		}
		driver.quit();
	}

}
