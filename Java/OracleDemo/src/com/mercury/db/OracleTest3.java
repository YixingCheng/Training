package com.mercury.db;

import java.sql.*;
import com.mercury.util.JdbcUtil;

import oracle.jdbc.internal.OracleTypes;

public class OracleTest3 {
	public static void main(String[] args){
		try{
			Connection conn = JdbcUtil.getConnection();
			String sp = "{?=call saveuser(?, ?)}";
			CallableStatement cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, "Scott");
			cs.setInt(3, 58);
			cs.execute();
			System.out.println("Return value: " + cs.getInt(1));
			sp = "{?=call queryuser()}";
			cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()){
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
			}
			rs.close();
		}catch(SQLException e){
			System.err.println(e);
		}
	}
}
