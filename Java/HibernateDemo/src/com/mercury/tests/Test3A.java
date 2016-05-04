package com.mercury.tests;

import org.hibernate.*;

import com.mercury.beans.People;
import com.mercury.util.HibernateUtil;

public class Test3A {
	
	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		
		People p = new People();
		p.setFirstName("John");
		p.setLastName("Cooper");
		//People p2 = (People) session.load(People.class, p);
		People p2 = (People) session.get(People.class, p);
		System.out.println("p == p2? " + (p == p2));
		System.out.println(p2);
		System.out.println("p == p2? " + (p == p2));
		System.out.println(p);
		HibernateUtil.closeSession();
		
	}

}
