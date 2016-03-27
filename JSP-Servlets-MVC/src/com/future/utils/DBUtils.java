package com.future.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private static String DB_DRIVER ;
	private static String DB_CONNECTION;
	private static String DB_USER;
	private static String DB_PASSWORD;
	
	static {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("db.properties");
			
			if (input == null) {
				System.out.println("Sorry, unable to find " + "db.properties");
			}
		    prop.load(input);
		    
		    DB_DRIVER = prop.getProperty("DB_DRIVER");
		    DB_CONNECTION = prop.getProperty("DB_CONNECTION");
		    DB_USER = prop.getProperty("DB_USER");
		    DB_PASSWORD = prop.getProperty("DB_PASSWORD");
		    
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
	
	public static void closeConnection(Connection conn) {
		if (conn == null) {
			return;
		}
        try {
        	conn.close();
        } catch(SQLException excep) {
        	System.out.println(excep.getMessage());
        }
	}
	
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement == null) {
			return;
	    }
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
