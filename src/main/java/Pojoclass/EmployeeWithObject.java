package Pojoclass;

public class EmployeeWithObject {
	
	String name;
	int phno;
	spouse spouse;
	
	public EmployeeWithObject(String name,int phno,spouse spouse)
	{
		super();
		this.name=name;
		this.phno=phno;
		this.spouse=spouse;
	}
	public EmployeeWithObject()
	{
		
	}
	public String getName() {
		return name;
	}
	public int getPhno() {
		return phno;
	}
	public spouse getSpouse() {
		return spouse;
	}
	

}
