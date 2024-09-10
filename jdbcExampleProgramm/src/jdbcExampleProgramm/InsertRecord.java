package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	static final String driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			// 1. load and register the driver
			Class.forName(driver);
			
			// 2.establish the connection 
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			// 3.CREATE THE STATEMENT
			statement = connection.createStatement();
			
			//prepare sql quwey
			
			String insertQuery = "INSERT INTO employee(eno,ename,esal,eaddr) VALUES(111,'SWAMY',4999.0,'hyd')";
			int rowsAffected = statement.executeUpdate(insertQuery);
			if(rowsAffected == 1) {
				System.out.println("records inserted succesfully");
			}else {
				System.out.println("record inserted failuer");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
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
