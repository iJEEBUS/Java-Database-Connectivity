package javaDatabase;

import java.util.Scanner;
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int path;
		System.out.println("\n== STUDENT DATABASE ==");
		System.out.println("\nWhat would you like to do today?");
		System.out.println("1 - Enter new student");
		System.out.println("2 - Dump all existing records");
		path = scan.nextInt();
		if (path == 1)
			newEntry();
		if (path == 2)
			dumpDatabase();

		scan.close(); // no memory leaks here
	}

	private static void dumpDatabase() {

		System.out.println("\n\nConnecting to database...\n\n");
		try {

			// Create connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "fuck off");

			// Create a statement
			Statement myStmt = myConn.createStatement();

			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from students");

			System.out.println("\n\nDumping data...\n\n");

			// Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getInt("id") + " " + 
						myRs.getString("last_name") + " " +
						myRs.getString("first_name") + " " +
						myRs.getString("email") + " " +
						myRs.getDouble("GPA") + " " +
						myRs.getString("year")
						);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Allows the user to create a new Student object
	 * and then add it to the database.
	 */
	private static void newEntry() {
		Scanner scan = new Scanner(System.in);
		Student new_student = new Student();

		System.out.println("Student ID number: ");
		new_student.setID(scan.nextInt());
		System.out.println("Last name: ");
		new_student.setLastName(scan.next());
		System.out.println("First name: ");
		new_student.setFirstName(scan.next());
		System.out.println("Email: ");
		new_student.setEmail(scan.next());
		System.out.println("GPA: ");
		new_student.setGPA(scan.nextDouble());
		System.out.println("Class standing: ");
		new_student.setYear(scan.next());
		scan.close();
		
		

		System.out.println("\n\nConnecting to database...\n\n");
		Connection myConn = connect();

	}

	private static Connection connect() {
		try {
			// Create connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "fuck off");		
			return myConn;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}




	/*
INSERT INTO sys.employees (id, last_name, first_name, email)
VALUES (0002, "Obama", "Barack", "oBOMBya@me.com");

SELECT * FROM sys.employees
	 */