package com.mercury.db;

import java.sql.*;
import java.util.Scanner;

import com.mercury.util.JdbcUtil;

public class OracleTest2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input name: ");
		String name = scanner.nextLine();
		try{
			Connection conn = JdbcUtil.getConnection();
			//String sql = "SELECT * FROM sample where name='" + name + "'";
			String sql = "SELECT * FROM sample WHERE name=?";
			//Statement st = conn.createStatement();
			//System.out.println("Hello1");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				//System.out.println("Hello");
				System.out.println(rs.getString("name")+ "\t" + rs.getInt("age"));
			}
			rs.close();
		} catch(SQLException e){
			System.err.println(e);
		}
		scanner.close();
	}
}
