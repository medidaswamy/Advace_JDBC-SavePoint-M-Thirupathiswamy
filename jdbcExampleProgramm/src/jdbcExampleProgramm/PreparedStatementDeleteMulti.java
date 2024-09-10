package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDeleteMulti {
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			// CREATE STATEMEMT
			
			preparedStatement = connection.prepareStatement(JDBC_URL);
			
			//prepare user for number of records to insert
			
			
				System.out.println("enter the salary threshold below will be deleted  : ");
				double esal = sc.nextDouble();
				
				
				String deleteSql = "delete from employee where esal <"+esal;
				int rowsAffected = preparedStatement.executeUpdate(deleteSql);
				System.out.println(rowsAffected+" record deleted succesfully");
				
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
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