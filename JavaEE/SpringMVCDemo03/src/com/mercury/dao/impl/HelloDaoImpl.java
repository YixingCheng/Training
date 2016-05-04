package com.mercury.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;

@Repository
public class HelloDaoImpl implements HelloDao {

    private HibernateTemplate template;
	
    @Autowired
	public void setSessionFactory(SessionFactory factory){
		template = new HibernateTemplate(factory);
	}
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		template.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		template.update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		return template.find("FROM User");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		template.delete(user);
	}
}
