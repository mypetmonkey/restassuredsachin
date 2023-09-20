package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.EmployeeWithObject;
import Pojoclass.spouse;

public class EmpSerializationWithObject {
	
	@Test
	public void EmployeeWithSerial() throws JsonGenerationException, JsonMappingException, IOException
	{
	int[] ar = {790817914,961477244};
	spouse sp = new spouse("suman",ar);
	EmployeeWithObject emp = new EmployeeWithObject("Rajhans",233455566,sp);
	ObjectMapper omap = new ObjectMapper();
	omap.writeValue(new File("data/emp.json"), emp);
	
	}

}
