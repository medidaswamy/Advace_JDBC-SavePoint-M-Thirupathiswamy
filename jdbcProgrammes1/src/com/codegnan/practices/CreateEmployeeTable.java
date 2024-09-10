package com.codegnan.practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class CreateEmployeeTable {
	
	//jdbc url,user name and password of mysql server
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE IF NOT EXISTS employee ("+"eno INT AUTO_INCREMENT PRIMARY KEY,"+"ename VARCHAR(100),"
						+"esal DECIMAL(10,2),"+"eaddr VARCHAR(255)"+")";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			statement = connection.createStatement();
			statement.execute(sql);
			System.out.println("Employee table create successfully");
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
