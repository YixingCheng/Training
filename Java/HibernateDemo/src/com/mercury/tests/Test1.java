package com.mercury.tests;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test1 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		//Configuration cfg = new Configuration().configure();   //read hibernate.cfg.xml
		//SessionFactory factory = cfg.buildSessionFactory();    //singleton, factory pattern
		//Session session = factory.openSession();
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		User user = new User("Tommy", 50);    //when hibernate read data from db, first store it 
		session.save(user);
		tx.commit();
		session.evict(user);
		String hql = "from User";
		Query query = session.createQuery(hql);
		System.out.println("******************************");
		List<User> list = query.list();
		//list.forEach(u -> System.out.println(u));
		//for(User u: list){
		//	System.out.println(u);
		//	System.out.println("user == u ?" + (user == u));
		//}
		for(int i= 0; i<list.size(); i++){
			System.out.println(list.get(i));
			System.out.println("user == u ?" + (user == list.get(i)));
			session.evict(list.get(i));
		}
		//session.close();
		HibernateUtil.closeSession();
		
	}
	
}
