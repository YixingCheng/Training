package com.mercury.tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

import oracle.jdbc.driver.OracleTypes;

public class Test2A {
	
	public static void main(String[] args) throws Exception{
		
		Session session = HibernateUtil.currentSession();
		
		Query query = session.getNamedQuery("userSP");
		List<User> list = query.list();
		for  (User u:list) System.out.println(u);
		
		Connection conn = session.connection();
		CallableStatement cs = conn.prepareCall("{?=call queryUser()}");
		cs.registerOutParameter(1, OracleTypes.CURSOR);
		cs.execute();
		ResultSet rs = (ResultSet) cs.getObject(1);
		while(rs.next()){
			System.out.println(rs.getString("Name") + "\t" + rs.getInt("Age"));
		}
		HibernateUtil.closeSession();
	}
}
