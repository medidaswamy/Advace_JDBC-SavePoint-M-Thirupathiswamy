package jdbcExampleProgramm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tableName =  "employee";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			statement = connection.createStatement();
			String sqlQuery = "drop table if exists "+tableName;
			statement.executeUpdate(sqlQuery);
			// string sqlquery -= statement.executeupdate ("drop table if exists employee);
			System.out.println("Table "+tableName+" deleted succesfully");
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
