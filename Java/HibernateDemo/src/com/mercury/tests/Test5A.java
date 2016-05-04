package com.mercury.tests;

import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5A {
	
	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		String hql = "FROM Customer as c left join fetct c.emails WHERE name=''Bob";
		//String hql = "from Customer WHERE name='Bob'";
		Customer c = (Customer) session.createQuery(hql).uniqueResult();
		System.out.println(c.getCID() + "\t" + c.getName());
		Set<String> emails = c.getEmails();
		//Hibernate.initialize(emails);
		HibernateUtil.closeSession();
		//Set<String> emails = c.getEmails();
		System.out.println("emails==null?" + (emails==null));
		for(String email:emails){
			System.out.println(email);
		}
		
	}

}
