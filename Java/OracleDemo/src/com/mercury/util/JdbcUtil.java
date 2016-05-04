package com.mercury.util;

import java.sql.*;

public class JdbcUtil {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@Ethan5558:1521:XE";
	private static final String USERNAME = "JavaMercury";
	private static final String PASSWORD = "123456Cyx";
	
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e){
			System.err.println(e);
		}
		return conn;
	}

}
