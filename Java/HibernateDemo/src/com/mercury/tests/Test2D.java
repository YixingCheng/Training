package com.mercury.tests;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.User;
import com.mercury.util.HibernateUtil;

public class Test2D {
	
	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		String hql= "update User set age=:age where name=:name";
		Transaction tx = session.beginTransaction();
		Query query= session.createQuery(hql);
		query.setInteger("age", 25);
		query.setString("name", "Tracy");
		query.executeUpdate();
		tx.commit();
		//second way:
		tx = session.beginTransaction();
		User user = (User) session.load(User.class, "Tommy");
		user.setAge(50);
		tx.commit();
		
		//third way
		Criteria ct = session.createCriteria(User.class);
		tx = session.beginTransaction();
		User user2 = (User) ct.add(Restrictions.eq("name", "scott")).uniqueResult();
		user2.setAge(70);
		tx.commit();
		HibernateUtil.closeSession();
		
	}

}
