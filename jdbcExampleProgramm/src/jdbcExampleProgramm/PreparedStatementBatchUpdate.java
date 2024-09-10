package jdbcExampleProgramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBatchUpdate {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			String sql = "update employee set esal = ? where eno = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setDouble(1, 72000);
			
			preparedStatement.setInt(2, 1);
			
			preparedStatement.addBatch();
			

			preparedStatement.setDouble(1, 7000);
			
			preparedStatement.setInt(2, 2);
			
			preparedStatement.addBatch();
			

			preparedStatement.setDouble(1, 6000);
			
			preparedStatement.setInt(2, 3);
			
			preparedStatement.addBatch();
			
			
			int[] updateCounts = preparedStatement.executeBatch();
			
			System.out.println("batch update is executed :");
			
			for(int i=0; i<updateCounts.length; i++) {
				System.out.println("update count for statement "+i+":"+updateCounts[i]);
			}
			
				
						
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
