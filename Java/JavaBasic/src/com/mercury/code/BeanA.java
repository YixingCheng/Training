package com.mercury.code;

public class BeanA implements Comparable<BeanA>{
	private int x;
	
	private final Base base = new Base();
	
	public BeanA(){	}
    public BeanA(int x){
    	this.x = x;
    }
    
    public Base getBase(){
    	return base;
    }
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int compareTo(BeanA a) {
		// TODO Auto-generated method stub
		if (x<a.x) return -1;
		else if (x==a.x) return 0;
		return 1;
	}
	
}
