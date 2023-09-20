package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.EmployeeWithArray;

public class EmpSerializationWithArray {

	
	@Test
	public void EmpDesrialArray() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[] ar = {790817914,961477244};
		EmployeeWithArray emp = new EmployeeWithArray("Sundeep",ar);
		ObjectMapper omap = new ObjectMapper();
		File  f = new File("data/dataArray.json");
		omap.writeValue(f, emp);
		
	
	    
		
	}
} 
