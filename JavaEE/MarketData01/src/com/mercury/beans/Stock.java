package com.mercury.beans;

public class Stock {
	private String sid;
	private double price;
	private double change;
	
	public Stock() {}
	public Stock(String sid) {
		this.sid = sid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
}
