package com.mercury.action;

import java.util.List;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.dao.impl.HelloDaoImpl;
import com.mercury.service.HelloService;

public class HelloAction {
	private String name;
	private int age;
	private String message;
	private List<User> users;
	private HelloService hs;
	private HelloDao hd;
	
	public HelloAction(){
		if (hs == null){
			hs = new HelloService();
		}
		if (hd == null){
			hd = new HelloDaoImpl();
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public HelloService getHs() {
		return hs;
	}
	public void setHs(HelloService hs) {
		this.hs = hs;
	}
	public HelloDao getHd() {
		return hd;
	}
	public void setHd(HelloDao hd) {
		this.hd = hd;
	}
	
	public String execute() {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		hd.save(user);
		message = hs.sayHello(user);
		users = hd.queryAll();
		return "RESULT";
	}
	
	
	
}
