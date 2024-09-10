package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateMultipleRecords {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	static final String driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		try {
			// 1. load and register the driver
			
			
			// 2.establish the connection 
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			// 3.CREATE THE STATEMENT
			statement = connection.createStatement();
			
			//prepare sql quwey
			
			System.out.println("Enter the employee salary threshold : ");
			double threshold = sc.nextDouble();
			
			System.out.println("Enter salary increment :");
			double salaryIncrement = sc.nextDouble();
			
			String updateSql = "update employee set esal = esal +"+salaryIncrement+"where esal <"+threshold;
			
			int rowsAffected = statement.executeUpdate(updateSql);
			System.out.println(rowsAffected+"records updated successfullt");
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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

