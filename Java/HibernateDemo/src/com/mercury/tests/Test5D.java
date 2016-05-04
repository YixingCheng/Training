package com.mercury.tests;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.Customer;
import com.mercury.util.HibernateUtil;

public class Test5D {
	
	public static void main(String[] args){
		Session session = HibernateUtil.currentSession();
		//Customer c = (Customer) session.get(Customer.class, 1);
		Criteria ct = session.createCriteria(Customer.class);
		Customer c = (Customer) ct.add(Restrictions.eq("name", "Bob")).uniqueResult();
		HibernateUtil.closeSession();
		System.out.println(c.getCID() + "\t" + c.getName());
		
		for(String email:c.getEmails()){
			System.out.println(email);
		}
	}
	
}
