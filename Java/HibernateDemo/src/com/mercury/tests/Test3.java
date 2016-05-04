package com.mercury.tests;

import java.util.List;



import org.hibernate.*;

import com.mercury.beans.People;
import com.mercury.util.HibernateUtil;

public class Test3 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		//People p = new People("John", "Cooper", 58);
		//Transaction tx = session.beginTransaction();
		//session.save(p);
		//tx.commit();
		String hql = "FROM People";
		List<People> list = session.createQuery(hql).list();
		for (People p1 : list){
			System.out.println(p1);
		}
		HibernateUtil.closeSession();
		
	}
	
}
