package com.mercury.tests;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1A {
	
	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		//user is in persistence status in session
		User user = (User) session.load(User.class, "Tommy");
		System.out.println(user);
		HibernateUtil.closeSession();
		//When session is closed, user is datached, but can be modified
		//user.setAge(42);
		
		user.setName("scott");
		// open a new session
		Session session2= HibernateUtil.currentSession();
		session2.merge(user);      //now the user is persistent with session2
		System.out.println("*********************************************");
		user = (User) session2.load(User.class, "Tommy");
		user.setAge(42);
		System.out.println(user);
		
        Transaction tx = session2.beginTransaction();
        tx.commit();
        HibernateUtil.closeSession();
		
	}

}
