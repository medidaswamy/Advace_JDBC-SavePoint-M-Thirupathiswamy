package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUsingMultipleRecordsInsert {
	
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			// established the connection.
			
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			//PREPARE SQL QUERY with parameters and without parameters
			
			String insertQuery = "insert into employee (eno,ename,esal,eaddr) values(?,?,?,?)";
			
			//create preparedStatement object;
			


			System.out.println("Enter the number of records to insert  :");
			
			int numOfRecords = sc.nextInt();
			
			for(int i=0; i<numOfRecords; i++) {
				System.out.println("enter details for record"+(i+1)+",");
				
				System.out.println("enter employee number : ");
				
				int eno = sc.nextInt();
				
				System.out.println("enter the employee name :");
				String ename = sc.next();
				
				System.out.println("enter the employeee salary  : ");
				double esal = sc.nextDouble();
				
				System.out.println("enter the employee addrea : ");
				String eaddr = sc.next();
				
				preparedStatement.setInt(1, eno);
				preparedStatement.setString(2, ename);
				preparedStatement.setDouble(3, esal);
				preparedStatement.setString(4, eaddr);
				
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected+"rows inserted successfully");
			}
			//execute the quer;y
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
