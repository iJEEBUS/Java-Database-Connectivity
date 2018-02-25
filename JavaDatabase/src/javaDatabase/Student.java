package javaDatabase;

public class Student {
	String first_name, last_name, email, year;
	double GPA;
	int ID;
	
	Student(String fname, String lname, String email, String year, double gpa, int id) {
		this.first_name = fname;
		this.last_name = lname;
		this.email = email;
		this.year = year;
		this.GPA = gpa;
		this.ID = id;
	}
	
	void setFirstName(String fname) {
		this.first_name = fname;
	}
	
	void setLastName(String lname) {
		this.last_name = lname;
	}
	
	void setEmail(String email) {
		this.email = email;
	}
	
	void setYear(String year) {
		this.year = year;
	}
	
	void setGPA(double gpa) {
		this.GPA = gpa;
	}
	
	void setID(int id) {
		this.ID = id;
	}
	
	String getFirstName() {
		return this.first_name;
	}
	
	String getLastName() {
		return this.last_name;
	}
	
	String getEmail() {
		return this.email;
	}
}