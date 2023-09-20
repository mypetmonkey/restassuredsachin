package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.Employee;

public class EmpSerialization {
	@Test
	public void EmployeeSerial() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper omap =new ObjectMapper();
		Employee emp = new Employee("Raju","E123","raju@gmail.com",790817914);
		File f=new File("data/data.json"); 
		omap.writeValue(f, emp);
		
	}

}
