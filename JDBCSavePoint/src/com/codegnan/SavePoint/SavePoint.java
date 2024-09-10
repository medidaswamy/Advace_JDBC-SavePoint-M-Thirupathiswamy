package com.codegnan.SavePoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


// perform this example we 

public class SavePoint {
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			//establish connection
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			
			//create the statement object
			statement = connection.createStatement();
			
			//display date before transaction
			
			connection.setAutoCommit(false);
			statement.executeUpdate("insert into politicians values('babau','tdp')");
			statement.executeUpdate("insert into politicians values('kcr','brs')");
			
			//create save point
			
			Savepoint sp = connection.setSavepoint();
			
			statement.executeUpdate("insert into politicians values('siddu','bjp')");
			
			System.out.println("oops.. Wrong entry, rolling back ");
			connection.rollback(sp);
			System.out.println("rollback successfully ");
			
			connection.commit();
			System.out.println("Transaction committed ");
			
			
			
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

