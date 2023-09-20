 package Pojoclass;

public class Employee {
	
	//declare the variable
	 String EmployeeName;
	 String EmpId;
	 String Email;
	 int Mobile;
	 
	 
	 public Employee(String EmployeeName,String EmpId,String Email,int Mobile)
	 {
		 this.EmployeeName=EmployeeName;
		 this.EmpId=EmpId;
		 this.Email=Email;
		 this.Mobile=Mobile;
	 }
	 
	 
	 public Employee() {
		 
	 }


	public String getEmployeeName() {
		return EmployeeName;
	}


	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}


	public String getEmpId() {
		return EmpId;
	}


	public void setEmpId(String empId) {
		EmpId = empId;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
   public void setMobile(int Mobile) {
	   this.Mobile = Mobile;
   }

	public int getMobile() {
		return Mobile;
	}
	 

}
