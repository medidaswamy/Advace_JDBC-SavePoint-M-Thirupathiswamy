package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateExample {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		
		
		
		try {
			
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			statement = connection.createStatement();
			
			//prepare the sql query
			
			String insertQuery = "insert into employee values(444,'swamy',6998,'ds')";
			
			String updateQuery = "update employee set esal = esal+1000 where esal < 50000";
			
			String deleteQuery = "delete from employee where esal <50000";
			
			statement.addBatch(insertQuery);
			statement.addBatch(updateQuery);
			statement.addBatch(deleteQuery);
			
			int[] updateCounts = statement.executeBatch();
			
			int totalUpdateCount = 0;
			
			for(int count:updateCounts) {
				totalUpdateCount = totalUpdateCount+count;
			}
			System.out.println("the no of rows updated : "+totalUpdateCount);
			
			
			
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
