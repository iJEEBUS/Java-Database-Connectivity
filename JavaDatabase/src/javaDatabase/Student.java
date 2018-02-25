package javaDatabase;

public class Student {
	
	/* Students name (first and last), email and current year */
	String first_name, last_name, email, year;
	
	/* Students current GPA */
	double GPA;
	
	/* Students ID number */
	int ID;
	
	/**
	 * Empty constructor
	 */
	Student(){}
	
	/**
	 * Constructor for a Student object. 
	 * All students must have a first name, last name, email, year, gpa, and id.
	 * 
	 * @param fname - first name of student
	 * @param lname - last name of student
	 * @param email - email of student
	 * @param year - current year of the student
	 * @param gpa - current GPA of the student
	 * @param id - students ID number
	 */
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
	
	String getYear() {
		return this.year;
	}
	
	double getGPA() {
		return this.GPA;
	}
	
	int getID() {
		return this.ID;
	}
}