package com.mercury.code;

public class Sub extends Base {
	int x = 5;
	public void foo(){
		System.out.println(x + " in sub");
	}
	
	public void process() {
		System.out.println("B");
	}
	
	public Sub(){
		foo();
	}
}
