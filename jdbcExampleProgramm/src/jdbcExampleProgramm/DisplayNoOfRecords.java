package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayNoOfRecords {

	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {
			
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			statement = connection.createStatement();
			
			String selectSql = "select count(*) as row_count from employee";
			
			//execute the query
			
			resultSet = statement.executeQuery(selectSql);
			
			
			while(resultSet.next()) {
				int rowCount = resultSet.getInt("row_count");
				
				System.out.println("The no of records in a employee table is : "+rowCount);
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
			}if(resultSet != null) {
				try {
					resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

	}
}
