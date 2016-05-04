package com.mercury.service;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.dao.HelloDao;
import com.mercury.dao.impl.HelloDaoImpl;

public class HelloService {
	
	private HelloDao hd;
	
	public HelloService() {
		if (hd == null){
			hd = new HelloDaoImpl();
		}
		System.out.println("Create an instance of HelloService");
	}
	
	public String sayHello1(User user){
			StringBuffer sb = new StringBuffer();
			sb.append("<h2 style='color: green'>");
			sb.append("Hello " + user.getName() + " with age "
					+ user.getAge() + ", welcome to JSP!");
			sb.append("</h2>");
			return sb.toString();
	}
	
	public String sayHello2(User user){
		return "Hello " + user.getName() + "(" + user.getAge()+ "), welcome to JSP!"; 
		
	}
	
	public UserInfo process(User user){
		hd.save(user);
		UserInfo info = new UserInfo();
		info.setMsg(this.sayHello2(user));
		info.setUsers(hd.queryAll());
		return info;
	}
	
}
