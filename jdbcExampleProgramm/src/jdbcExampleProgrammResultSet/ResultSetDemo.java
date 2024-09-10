package jdbcExampleProgrammResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
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
			
			// CREATE THE STATEMENT OBJECT
			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			//prepare sql query
			
			String sqlQuery = "select *from employee";
			
			//process result from resultset
			
			resultSet = statement.executeQuery(sqlQuery);
			
			System.out.println("records in forward direction :");
			System.out.println(" ");
			System.out.println("eno\tename\tesal\teaddr");
			System.out.println("====================================================================");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getRow()+"-------->"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3)+"\t"+resultSet.getString(4));
				// we using the resultset.getRow
				
			}
			
			
			System.out.println("records in backward direction :");
			System.out.println(" ");
			System.out.println("eno\tename\tesal\teaddr");
			System.out.println("====================================================================");
			
			while(resultSet.previous()) {
				System.out.println(resultSet.getRow()+"-------->"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3)+"\t"+resultSet.getString(4));
				
				
			}
			System.out.println("we using the methods ");
			System.out.println();
			resultSet.first();
			System.out.println(resultSet.getRow()+"-------->"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3)+"\t"+resultSet.getString(4));
			
			resultSet.last();
			System.out.println(resultSet.getRow()+"-------->"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3)+"\t"+resultSet.getString(4));
			
			resultSet.relative(-1);
			System.out.println(resultSet.getRow()+"-------->"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3)+"\t"+resultSet.getString(4));
			
			resultSet.absolute(2);
			System.out.println(resultSet.getRow()+"-------->"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getDouble(3)+"\t"+resultSet.getString(4));
			
			System.out.println(resultSet.isFirst());
			System.out.println(resultSet.isLast());
			//resultSet.beforeFirst();
			//resultSet.afterLast();
			System.out.println(resultSet.isBeforeFirst());
			System.out.println(resultSet.isAfterLast());
			
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
			if(resultSet != null) {
				try {
					resultSet.close();
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
