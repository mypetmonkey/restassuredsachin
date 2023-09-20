package Pojoclass;

public class EmployeeWithArray {

	String name;
    int[] phno;

public EmployeeWithArray(String name,int[] phno)
{
	 this.name=name;
	 this.phno=phno;
}
public EmployeeWithArray()
{
	
}
public String getName() {
	return name;
}
public int[] getPhno() {
	return phno;
}
}
