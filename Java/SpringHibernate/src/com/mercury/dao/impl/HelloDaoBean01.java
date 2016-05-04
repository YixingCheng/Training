package com.mercury.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

public class HelloDaoBean01 extends HibernateDaoSupport implements HelloDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("FROM User");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);
	}

}
