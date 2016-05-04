package com.mercury.db;

import java.sql.*;

import com.mercury.util.JdbcUtil;

public class OracleTest1 {
	
	public static void main(String[] args){
		try{
			Connection conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO sample VALUES('Steven', 55)";
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			sql = "SELECT * FROM sample";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
			}
			rs.close();
		} catch (SQLException e){
			System.err.println(e);
		}
	}
}
