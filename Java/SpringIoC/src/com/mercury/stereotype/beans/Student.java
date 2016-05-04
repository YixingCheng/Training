package com.mercury.stereotype.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private int sid;
	private String name;
	@Autowired
	private Address address;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
