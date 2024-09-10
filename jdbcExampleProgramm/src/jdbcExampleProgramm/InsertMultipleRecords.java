package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMultipleRecords {
	
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
			
			System.out.println("Enter the no of records to insert : ");
			int numRecords = sc.nextInt();
			
			sc.nextLine();
			
			for(int i = 0; i < numRecords; i++) {
				System.out.println("Enter details of records "+(i+1)+":");
				
				System.out.println("Enter the employee id : ");
				int eno = sc.nextInt();
				
				System.out.println("Enter the employee name : ");
				String ename = sc.next();
				
				System.out.println("Enter the employee salary :");
				double esal = sc.nextDouble();
				
				System.out.println("Enter the employee address :");
				String eaddr = sc.next();
				
				String insertSql = "insert into employee(eno,ename,esal,eaddr) values("+eno+","+ename+","+esal+","+eaddr+")";
				
				int rowsAffected = statement.executeUpdate(insertSql);
				
				if(rowsAffected == 1) {
					System.out.println("Record "+(i+1)+"inserted succesfully ");
				}else {
					System.out.println("Failed to insert record"+(i+1));
				}
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
