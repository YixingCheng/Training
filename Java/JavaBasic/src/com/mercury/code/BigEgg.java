package com.mercury.code;

public class BigEgg extends Egg{
	public class Yolk extends Egg.Yolk{
		public Yolk() {
			System.out.println("BigEgg.Yolk");
		}
		public void f(){
			System.out.println("BigEgg.Yolk.f");
		}
	}
	public BigEgg(){
		insertYolk(new Yolk());
	}
}
