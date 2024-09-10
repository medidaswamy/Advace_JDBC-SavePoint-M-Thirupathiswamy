package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AveragesSalaryemployee {

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
			
			String selectSql = "select avg(esal) as average_salary from employee";
			
			//execute the query
			
			resultSet = statement.executeQuery(selectSql);
			
			if(resultSet.next()) {
				double averageSalary = resultSet.getDouble("average_salary");
				System.out.println("average salary of employee : "+averageSalary);
			}else {
				System.out.println("no data available");
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
