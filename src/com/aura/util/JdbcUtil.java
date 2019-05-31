package com.aura.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtil {
 static	private String url;
 static	private	String username;
 static	private	String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
			try {
				Class.forName(bundle.getString("driver"));
				 url=bundle.getString("url");
				 username =bundle.getString("username");
				 password =bundle.getString("password");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 释放资源
	public static void closeAll(Connection connection, PreparedStatement stat, ResultSet rs) {
		try {
			
			stat.close();
			connection.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection connection, PreparedStatement stat) {
		try {
			connection.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
