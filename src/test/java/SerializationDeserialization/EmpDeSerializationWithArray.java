package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.EmployeeWithArray;

public class EmpDeSerializationWithArray {

	@Test
	public void EmployeeDeserial() throws JsonParseException, JsonMappingException, IOException
	{
      ObjectMapper omap = new ObjectMapper();
      File f=new File("data/dataArray.json");
      EmployeeWithArray data = omap.readValue(f,EmployeeWithArray.class);
      System.out.println(data.getName());
      System.out.println(data.getPhno()[0]);
      System.out.println(data.getPhno()[1]);
      
           }
    }
