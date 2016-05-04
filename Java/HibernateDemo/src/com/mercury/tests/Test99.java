package com.mercury.tests;

import org.hibernate.Session;

import com.mercury.beans.People;
import com.mercury.util.HibernateUtil;

public class Test99 {

	public static void main(String[] args){
		
		Session session = HibernateUtil.currentSession();
		//People p = (People) session.load(People.class, new PKField("Ethan","Cheng"));
		
	}
	
}
