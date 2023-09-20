package headervalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class ValidateHeader {
	
	@Test
	public void headvaldte() {
	baseURI="http://rmgtestingserver";
	port=8084;
	
	String exp_StatusLine="HTTP/1.1 200 ";
	String exp_vary="Access-Control-Request-Headers";
	String exp_contType="application/json";
	String exp_pragma="no-cache";
	String exp_Connection="keep-value";
	
	 Response resp = when().get("/projects/TY_PROJ_6379");
	ResponseBody body = resp.body();
	System.out.println(body.asPrettyString());
	
	Headers head=resp.getHeaders();
	System.out.println(head);
	String statusLine=resp.statusLine();
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, exp_StatusLine);
	
	String act_vary=resp.getHeader("vary");
	System.out.println(act_vary);
	Assert.assertEquals(act_vary, exp_vary);
	
	String act_content=resp.getHeader("Content-Type");
	Assert.assertEquals(act_content, exp_contType);
	
	
	
	}

}
