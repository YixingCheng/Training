package com.mercury.beans;

import java.io.Serializable;

public class People implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2344770985375403116L;
	private String firstName;
	private String lastName;
	private int age;
	
	public People(){};
	
	public People(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "Hello world " + this.firstName + " " + this.lastName + ", you are " + this.age + "."; 
	}
	
}
