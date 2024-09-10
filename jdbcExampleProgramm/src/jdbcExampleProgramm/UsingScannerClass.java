package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsingScannerClass {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	static final String driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			 connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			 
			 
			 statement = connection.createStatement();
			 System.out.println("enter the employee number");

			 int eno = sc.nextInt();
			 System.out.println("Enter the employee name");
			 String ename = sc.next();
			 System.out.println("Employee salary : ");
			 double esal = sc.nextDouble();
			 System.out.println("Enter the address");
			 String eaddr = sc.next();
			 
			 //prepare sql query
			 String insertQuery = "INSERT INTO employee(eno,ename,esal,eaddr) VALUES("+eno+","+ename+","+esal+","+eaddr+")";
			 int rowsAffected = statement.executeUpdate(insertQuery);
			 if(rowsAffected == 1) {
				 System.out.println("records inserted succesfully");
			 }else {
				 System.out.println("records inserted failure");
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
