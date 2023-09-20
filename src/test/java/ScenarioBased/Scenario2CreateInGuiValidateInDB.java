package ScenarioBased;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.DatabaseLiberary;
import genericutilities.EndPointLiberary;
import genericutilities.Iconstant;
import genericutilities.JavaLiberary;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class Scenario2CreateInGuiValidateInDB extends BaseClass implements Iconstant,EndPointLiberary{
	
	@Test
	public void createpro() throws InterruptedException, SQLException {
		JavaLiberary j=new JavaLiberary();
		
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
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String pname="banking77"+j.random();
		driver.findElement(By.name("projectName")).sendKeys(pname);
		driver.findElement(By.name("createdBy")).sendKeys("Rajhans37");
		 WebElement all = driver.findElement(By.name("status"));
		Select s=new Select(all);
		s.selectByValue("On Going");
		driver.findElement(By.xpath("(//option[text()='On Gogin'])[2]")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		String id=driver.findElement(By.xpath("//td[.='"+pname+"']/ancestor::tr/descendant::td[1]")).getText();
		driver.quit();
		
		
		DatabaseLiberary dlib=new DatabaseLiberary();
		dlib.connectToDB();
		String quary="select * from project;";
		String pid = dlib.readDataFromDBAndValidate(quary, 1, id );
		System.out.println(pid);
		dlib.closeDB();
		Assert.assertEquals(pid, id);
		
		when()
		.get(getSingleProject+"pid")
		
		.then()
		.log().all();
	}

}
