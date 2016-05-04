package com.mercury.code;

import java.util.Date;

public final class Immutable {
	private final String str;
	private final int num;
	private final Date date;
	
	public Immutable(String str, int num, Date date){
		this.str = str;
		this.num = num;
		this.date = date;
	}
	
	public String getStr(){
		return this.str;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public Date getDate(){
		return new Date();
	}
}
