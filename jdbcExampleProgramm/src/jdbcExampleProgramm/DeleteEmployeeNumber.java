package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmployeeNumber {
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			// CREATE STATEMEMT
			
			statement = connection.createStatement();
			
			//prepare user for number of records to insert
			
			
				System.out.println("Enter employee number to delete : ");
				int enoToDelete = sc.nextInt();
				
				String deleteSql = "delete from employee where eno ="+enoToDelete;
				
				int rowsAffected = statement.executeUpdate(deleteSql);
				
				if(rowsAffected >0) {
					System.out.println("record with employee number"+enoToDelete+"deleted successfully");
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