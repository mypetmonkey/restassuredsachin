package Pojoclass;

public class spouse {
	String sname;
	int[] phno;
	
	public spouse(String sname,int[] phno)
	{
		this.sname=sname;
		this.phno=phno;
	}
	public spouse()
	{
			
	}
	
	public String getsname() {
		return sname;
	}
	public int[] getPhno() {
		return phno;
	}
	

}
