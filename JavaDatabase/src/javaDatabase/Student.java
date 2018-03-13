package javaDatabase;

public class Student {
	
	/** Students name (first and last), email and current year **/
	String first_name, last_name, email, year;
	
	/** Students current GPA **/
	double GPA;
	
	/** Students ID number **/
	int ID;
	
	/*******************************************************************************************************
	 * Empty constructor
	 ******************************************************************************************************/
	Student(){}
	
	/*******************************************************************************************************
	 * Constructor for a Student object. 
	 * All students must have a first name, last name, email, year, gpa, and id.
	 * 
	 * @param fname - first name of student
	 * @param lname - last name of student
	 * @param email - email of student
	 * @param year - current year of the student
	 * @param gpa - current GPA of the student
	 * @param id - students ID number
	 ******************************************************************************************************/
	Student(String fname, String lname, String email, String year, double gpa, int id) {
		this.first_name = fname;
		this.last_name = lname;
		this.email = email;
		this.year = year;
		this.GPA = gpa;
		this.ID = id;
	}
	
	/*******************************************************************************************************
	 * Set the students first name
	 * 
	 * @param fname students first name
	 ******************************************************************************************************/
	void setFirstName(String fname) {
		this.first_name = fname;
	}
	
	/*******************************************************************************************************
	 * Set the student's last name
	 * 
	 * @param fname students last name
	 ******************************************************************************************************/
	void setLastName(String lname) {
		this.last_name = lname;
	}
	
	/*******************************************************************************************************
	 * Set the student's email
	 * 
	 * @param fname student's email
	 ******************************************************************************************************/
	void setEmail(String email) {
		this.email = email;
	}
	
	/*******************************************************************************************************
	 * Set the students current academic year
	 * 
	 * @param fname students current academic year
	 ******************************************************************************************************/
	void setYear(String year) {
		this.year = year;
	}
	
	/*******************************************************************************************************
	 * Set the students GPA
	 * 
	 * @param fname student's GPA
	 ******************************************************************************************************/
	void setGPA(double gpa) {
		this.GPA = gpa;
	}
	
	/*******************************************************************************************************
	 * Set the student's ID
	 * 
	 * @param fname student's ID
	 ******************************************************************************************************/
	void setID(int id) {
		this.ID = id;
	}
	
	/*******************************************************************************************************
	 * Get the student's first name
	 * 
	 * @return fname student's first name
	 ******************************************************************************************************/
	String getFirstName() {
		return this.first_name;
	}
	
	/*******************************************************************************************************
	 * Get the student's last name
	 * 
	 * @return fname student's last name
	 ******************************************************************************************************/
	String getLastName() {
		return this.last_name;
	}
	
	/*******************************************************************************************************
	 * Get the student's email
	 * 
	 * @return fname student's email
	 ******************************************************************************************************/
	String getEmail() {
		return this.email;
	}
	
	/*******************************************************************************************************
	 * Get the student's year
	 * 
	 * @return fname student's year
	 ******************************************************************************************************/
	String getYear() {
		return this.year;
	}
	
	/*******************************************************************************************************
	 * Get the student's GPA
	 * 
	 * @return fname student's GPA
	 ******************************************************************************************************/
	double getGPA() {
		return this.GPA;
	}
	
	/*******************************************************************************************************
	 * Get the student's ID
	 * 
	 * @return fname student's ID
	 ******************************************************************************************************/
	int getID() {
		return this.ID;
	}
}