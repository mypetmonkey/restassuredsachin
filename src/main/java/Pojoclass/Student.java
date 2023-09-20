package Pojoclass;

public class Student {
	String name;
	int rollno;
	double perc;
	char grade;
	public Student(String n,int r,double p, char g) {
		this.name=n;
		this.rollno=r;
		this.perc=p;
		this.grade=g;
	}
	Student(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	

}
