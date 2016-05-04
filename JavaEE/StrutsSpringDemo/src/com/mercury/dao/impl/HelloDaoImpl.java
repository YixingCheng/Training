package com.mercury.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.JdbcUtil;

import oracle.jdbc.OracleTypes;

@Repository
public class HelloDaoImpl implements HelloDao {
	
	private SimpleJdbcTemplate template;
    @Autowired
	public void setDataSource(DataSource dataSource){
		template = new SimpleJdbcTemplate(dataSource);
	}
	

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Object[] params = {user.getName(), user.getAge()};
		String sql="INSERT INTO sample VALUES(?, ?)";
		template.update(sql, params);      //CMP   content management persistence
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Object[] params = {user.getAge(), user.getName()};
		String sql = "UPDATE sample SET Age=? WHERE Name=?";
		template.update(sql, params);
	}
	

	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM sample";
		return template.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int line) throws SQLException {
				User user = new User();
				user.setName(rs.getString("Name"));
				user.setAge(rs.getInt("Age"));
				return user;
			}
		});
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Object[] params = {user.getName(), user.getAge()};
		String sql = "DELETE sample WHERE Name=? and Age=?";
		template.update(sql, params);
	}

}
