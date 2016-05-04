package com.mercury.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.JdbcUtil;

import oracle.jdbc.OracleTypes;

public class HelloDaoImpl implements HelloDao {
	
	private Connection conn;
	
	private Connection getConnection(){
		return JdbcUtil.getConnection();
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try{
			conn = getConnection();
			//conn.setAutoCommit(false);
			String sp = "{?=call saveuser(?, ?)}";
			CallableStatement cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, user.getName());
			cs.setInt(3, user.getAge());
			cs.execute();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try{
			conn = getConnection();
			//conn.setAutoCommit(false);
			String sql = "UPDATE sample "
					     + "SET age=? "
					     + "WHERE name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, user.getName());
			ps.setInt(1, user.getAge());   
			ps.execute();   //executeQuery()
			ps.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		try{
			conn = getConnection();
			//conn.setAutoCommit(false);
			String sql = "DELETE FROM sample "
					     + "WHERE name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, user.getName());
			ps.setInt(1, user.getAge());   
			ps.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		
		try{
			conn = getConnection();
			//conn.setAutoCommit(false);
			String sp = "{?=call queryuser()}";
			CallableStatement cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				User user = new User();
				user.setName(name);
				user.setAge(age);
				users.add(user);
			}
			
			rs.close();
			
		} catch(SQLException e){
			e.printStackTrace();
			
		} 
		return users;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		
		User user = null;
		try{
			conn = getConnection();
			//conn.setAutoCommit(false);
			String sql = "SELECT * FROM sample WHERE name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
					
			if (rs.next()){
				
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
			}
			
			rs.close();
		} catch(SQLException e){
			e.printStackTrace();
			
		}
		return user;
	}

}
