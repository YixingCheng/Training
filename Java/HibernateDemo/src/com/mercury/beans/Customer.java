package com.mercury.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int CID;
	private String name;
	private Set<String> emails;
	
	public Customer(){
		this.emails = new HashSet<String>();
	}
	
	public Customer(String name){
		this();
		this.name = name;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int CID) {
		this.CID = CID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	};
	
	public void addEmail(String email) {
		emails.add(email);
	};
	
	public void removeEmail(String email){
		emails.remove(email);
	}
	
	
	

}
