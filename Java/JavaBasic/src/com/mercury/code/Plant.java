package com.mercury.code;

class Plant {
	String name;
	
	public Plant(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}

class Tree extends Plant{
	
	public void growFruit(){}
	public void dropLeaves(){}
}
