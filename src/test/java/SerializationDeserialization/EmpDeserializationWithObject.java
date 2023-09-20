 package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.EmployeeWithArray;

public class EmpDeserializationWithObject {
	
	@Test
	public void EmpDesrialArray() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[] ar = {790817914,961477244};
		EmployeeWithArray emp = new EmployeeWithArray("Sundeep",ar);
		ObjectMapper omap = new ObjectMapper();
		omap.writeValue(new File("data/dataArray.json"), emp);
		System.out.println(emp.getName());
		for(int t:ar)
		System.out.println(t);
	
	}

}
