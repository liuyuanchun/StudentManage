package com.situ.student.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String url ;
	private static String username ;
	private static String password;
	private static String driverClass;
	static {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/db.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		try {
			properties.load(fileInputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			if(fileInputStream != null){
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		driverClass = properties.getProperty("driverClass");
		try {
			//1.¼ÓÔØÇý¶¯
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,username ,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(Connection connection, Statement statement) {
		if(statement != null){
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet resultSet,Connection connection, Statement statement) {
		if(resultSet != null){
			try {
				resultSet.close();
				resultSet = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement != null){
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
