package genericutilities;

import java.util.Date;
import java.util.Random;

public class JavaLiberary {
	public int random() {
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;
	}
	
	public String getSyatemDate() {
		Date dt=new Date();
		String date = dt.toString();
		return date;
	}
}
