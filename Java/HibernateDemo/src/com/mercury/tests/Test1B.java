package com.mercury.tests;

import org.hibernate.Session;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1B {
	public static void main(String[] args){
		
		Session session1 = HibernateUtil.currentSession();
		User user1 = (User) session1.load(User.class, "Tommy");
		System.out.println(user1);
		HibernateUtil.closeSession();
		try{
			Thread.sleep(6000);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Session session2 = HibernateUtil.currentSession();
		User user2 = (User) session2.load(User.class, "Tommy");
		System.out.println(user2);
		HibernateUtil.closeSession();
		
		Session session3 = HibernateUtil.currentSession();
		User user3 = (User) session3.load(User.class, "Tommy");
		System.out.println(user3);
		System.out.println("user2==user3? " + (user2==user3));
		System.out.println(user2.getName() == user3.getName());
		HibernateUtil.closeSession();
	}
}
