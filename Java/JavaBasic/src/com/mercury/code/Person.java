package com.mercury.code;

public final class Person {    //this class is final
	private String name;  //all fields are private
	
	public Person(){};
	public Person(String name){  //provide a constructor to initialize fields
		this.name = name;
	}
	
	public String getName(){   //you can only have getter, no setter
		return name;    
	}
	
	public Person addPrefix(String prefix){
		return new Person(prefix + " " + name);
	}
	
}
