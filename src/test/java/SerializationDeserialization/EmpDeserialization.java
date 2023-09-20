package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.Employee;

public class EmpDeserialization {
	@Test
	public void EmployeeDesrial() throws JsonParseException, JsonMappingException, IOException
	{
	   ObjectMapper omap = new ObjectMapper();
	
	   Employee data =omap.readValue(new File("data/data.json"),Employee.class);
	   System.out.println(data.getEmail());
	   System.out.println(data.getEmpId());
	   System.out.println(data.getEmployeeName());
	   System.out.println(data.getMobile());
	
	}
}
