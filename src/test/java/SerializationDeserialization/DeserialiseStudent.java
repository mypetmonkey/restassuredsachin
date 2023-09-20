package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass.Student;

public class DeserialiseStudent {
	
	@Test
	public void deserializestud() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		File f = new File("data/student.json");
		Student data=omap.readValue(f, Student.class);
		System.out.println(data.getName());
		System.out.println(data.getRollno());
		System.out.println(data.getPerc());
		System.out.println(data.getGrade());
	}

}
