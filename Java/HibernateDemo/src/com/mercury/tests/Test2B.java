package com.mercury.tests;

import org.hibernate.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2B {
	
	public static void main(String[] args){
		try{
			Session session = HibernateUtil.currentSession();
			//compare load and get
			User user1 = (User) session.load(User.class, "scott");
			//user1 is a proxy object, but it is not null
			System.out.println("user1 == null?" + (user1 == null));
			System.out.println("Line before query ******************");
			System.out.println(user1);     //this line will trigger the query
			User user2 = (User) session.get(User.class, "Tommy");
			System.out.println("Line after query ******************");
			System.out.println(user2);
			
			//User user3 = (User) session.get(User.class, "abcd");
			//System.out.println(user3);
			//User user4 = (User) session.load(User.class, "abcd");
			//System.out.println(user4);
			
		} finally{
			HibernateUtil.closeSession();
		}
	}
	
}
