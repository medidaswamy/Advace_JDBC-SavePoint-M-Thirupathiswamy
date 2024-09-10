package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInsertRecords {
	
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		try {
			// established the connection.
			
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			//PREPARE SQL QUERY with parameters and without parameters
			
			String insertQuery = "insert into employee (eno,ename,esal,eaddr) values(?,?,?,?)";
			
			//create preparedStatement object;
			
			preparedStatement = connection.prepareStatement(insertQuery);
			
			// set the values to a positional parameters
			
			preparedStatement.setInt(1, 222);
			
			preparedStatement.setString(2, "codegnan");
			
			preparedStatement.setDouble(3, 60000);
			
			preparedStatement.setString(4, "hyd");
			
			//execute the quer;y
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected+"rows inserted successfully");
			
			
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
