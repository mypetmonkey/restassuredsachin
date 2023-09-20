package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.Student;

public class SerialiseStudent {
	
	@Test
	public void testStudent() throws JsonGenerationException, JsonMappingException, IOException{
		Student s=new Student("Rajhans",102,91.2,'A');
		ObjectMapper omap=new ObjectMapper();
		File f=new File("data/student.json");
		omap.writeValue(f, s);
		
	}

}
