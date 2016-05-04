package com.mercury.code;

public class BeanB {
    private int x;
    
    private final Base base = new Base();
	
	public BeanB(){	}
    public BeanB(int x){
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
}
