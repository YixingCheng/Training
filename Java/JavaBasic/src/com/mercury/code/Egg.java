package com.mercury.code;

public class Egg {
	protected class Yolk{
		public Yolk(){
			System.out.println("Egg.Yook");
		}
		public void f(){
			System.out.println("Egg2.Yolk.f");
		}
	}
	private Yolk y = new Yolk();
	public Egg(){
		System.out.println("New Egg");
	}
	public void insertYolk(Yolk yy){
		y = yy;
	}
	public void g(){
		y.f();
	}
}
