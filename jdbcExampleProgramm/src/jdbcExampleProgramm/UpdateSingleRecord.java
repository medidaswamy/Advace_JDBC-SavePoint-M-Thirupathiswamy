package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSingleRecord {
	
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
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			// CREATE STATEMEMT
			
			statement = connection.createStatement();
			
			//prepare user for number of records to insert
			
			
			
			
				System.out.println("Enter the employee number to update : ");
				int eno = sc.nextInt();
				
				System.out.println("Enter the employee name : ");
				String ename = sc.next();
				
				System.out.println("Enter the employee salary :");
				double esal = sc.nextDouble();
				
				System.out.println("Enter the employee address :");
				String eaddr = sc.next();
				
				String updateSql = "update employee set ename ='"+ename+"',esal ="+esal+",eaddr ='"+eaddr+"'where eno ="+eno;
				int rowsAffected = statement.executeUpdate(updateSql);
				if(rowsAffected >0) {
					System.out.println();
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
