package com.mercury.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

@Repository
public class HelloDaoBean01 implements HelloDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.currentSession();
		//if you want to use getCureentSession(), all operations has to be in the transaction
		//
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> users=query.list();
		tx.commit();
		return users;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, name);
		tx.commit();
		return user;
	}
	
}
