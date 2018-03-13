package javaDatabase;

import java.util.Scanner;
import java.sql.*;

/*******************************************************************************************************
 * This is is the main class of my example connection between a Java application and a mySQL database.
 * Handles the logic of the program along with the user input. 
 * 
 * @author Ronald Rounsifer
 * @version 1.2
 *****************************************************************************************************/
public class Driver {
	
	/** Program runs infinitely when true **/
	static boolean run = true;
	
	/*******************************************************************************************************
	 * Insertion point for the software.
	 * 
	 * @param args
	 ******************************************************************************************************/
	public static void main(String[] args) {
		// used to read the user input
		Scanner scan = new Scanner(System.in);
		while (run)
			run(scan);
		scan.close();
		System.exit(0);
	}

	/*******************************************************************************************************
	 * Prompts for the users input and navigates them to the 
	 * correct section of code to execute.
	 * 1 - Enter new student into database
	 * 2 - Dump all existing database records
	 * 3 - Exit the application
	 * 
	 * @param scan
	 ******************************************************************************************************/
	private static void run(Scanner scan) {
		int path;
		System.out.println("\n== STUDENT DATABASE ==");
		System.out.println("\nWhat would you like to do today?");
		System.out.println("1 - Enter new student");
		System.out.println("2 - Dump all existing records");
		System.out.println("3 - Exit\n");
		path = scan.nextInt();
		if (path == 1)
			newEntry(scan);
		if (path == 2)
			dumpDatabase();
		if (path == 3)
			exit();
	}

	/*******************************************************************************************************
	 * Sets the global run variable to false, causing the application to exit.
	 ******************************************************************************************************/
	private static void exit() {
		run = false;
		System.out.println("\nDestroying any connections left......(╯°□°）╯︵ ┻━┻");
		System.out.println("\nIt's so lonely now......੨( ･᷄ ︵･᷅ )ｼ");
		System.out.println("\nAtleast no memory leaks exist......(๑˃̵ᴗ˂̵)و");
		System.out.println("\nEither way..have some waffles......(>°ᴗ°)>###");
	}

	/*******************************************************************************************************
	 * Used to dump the entirety of the database into the console.
	 ******************************************************************************************************/
	private static void dumpDatabase() {

		System.out.println("\n\nConnecting to database...\n\n");
		try {
			// Create connection to database
			Connection myConn = connect();

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
			System.out.println("\n\nClosing database connection...\n\n");
			myConn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*******************************************************************************************************
	 * Allows the user to create a new Student object
	 * and then add it to the database.
	 ******************************************************************************************************/
	private static void newEntry(Scanner scan) {
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

		// Query to insert student
		String query = "INSERT INTO students (id, last_name, first_name, email, GPA, year)" +
				"VALUES (?,?,?,?,?,?)";

		System.out.println("\n\nConnecting to database...\n\n");

		try {
			// Connect to database
			Connection myConn = connect();
			
			// Prepare the query
			PreparedStatement  preparedStmt = myConn.prepareStatement(query);
			preparedStmt.setInt	(1, new_student.getID());
			preparedStmt.setString(2, new_student.getLastName());
			preparedStmt.setString(3, new_student.getFirstName());
			preparedStmt.setString(4, new_student.getEmail());
			preparedStmt.setDouble(5, new_student.getGPA());
			preparedStmt.setString(6, new_student.getYear());
			
			// Execute the query
			preparedStmt.execute();
			
			System.out.println("\n\nClosing database connection...\n\n");
			myConn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************************************************************
	 * Creates a connection between this application and the locally hosted 
	 * MySQL database.
	 * 
	 * @return myConn - connection to the database
	 ******************************************************************************************************/
	private static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
			String user = "root";
			String password = ""; // password removed since I actually use this database
			// Create connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);		
			return myConn;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}