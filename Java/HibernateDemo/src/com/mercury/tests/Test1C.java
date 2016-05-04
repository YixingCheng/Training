package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1C {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		query.setCacheable(true);       //query is cached
		List<User> list = query.list();
		for (User u:list){
			System.out.println(u);
		}
		//When we run query.list() again, it will not run any query
		List<User> list2 = query.list();
		for (User u:list2){
			System.out.println(u);
		}
		HibernateUtil.closeSession();
	}

}
