package Pojoclass;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGYantra {

	static boolean getResult(String data,List<WebElement> teams) {
		for(WebElement allteam:teams) {
			String text=allteam.getText();
 			if(data.equalsIgnoreCase(text))
				return true;
		}
		return false;
	}
	@Test
	public void test() throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any  name");
		String data=sc.next();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul/li/a[.='Projects']")).click();
        driver.findElement(By.linkText("Projects")).click();
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		int count=teams.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String d=teams.get(i).getText();
			System.out.println(d);
		}
		boolean b=getResult(data,teams);
		if(b)
			System.out.println(data+" : yes this name is present");
		else
			System.out.println(data+"  : this name is not present");
		driver.close();
		sc.close();
	}

}
