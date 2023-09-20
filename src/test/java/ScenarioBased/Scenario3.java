package ScenarioBased;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Scenario3 extends BaseClass implements Iconstant,EndPointLiberary{
	
	@Test
	public void createPro() throws SQLException, InterruptedException {
		JavaLiberary j=new JavaLiberary();
		NewProject np=new NewProject("Rajhans","bankingOnline"+j.random(), "ongoing", 24);
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
		
		DatabaseLiberary dlib=new DatabaseLiberary();
		dlib.connectToDB();
		String quary="select * from project;";
		String expid = dlib.readDataFromDBAndValidate(quary, 1, proid);
		
		if(proid.equals(expid)) {
			when()
			.get(getSingleProject+"proid")
			
			.then().log().all();
		}
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys(appUserName);
		driver.findElement(By.id("inputPassword")).sendKeys(appPwd);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		List<WebElement> allProname = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		
		
		
	}

}
