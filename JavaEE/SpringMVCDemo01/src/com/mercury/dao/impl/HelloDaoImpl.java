package com.mercury.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.HibernateUtil;

@Repository
public class HelloDaoImpl implements HelloDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.currentSession();
		//if you want to use getCureentSession(), all operations has to be in the transaction
		//
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> users=query.list();
		return users;
	}

	
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		User user = (User) session.load(User.class, name);
		return user;
	}

}
