package com.mercury.code.test;

import com.mercury.code.Base;
import com.mercury.code.Derived;

public class TestBase {
	public static void main(String[] args) {
		/*Base b = new Derived();
		System.out.println(b.getValue());
		System.out.println(b.getClass());
		if (b instanceof Base){
			System.out.println("It's base");
		}
		if (b instanceof Derived){
			System.out.println("It's derived");
		}*/
		Base base = new Base();
		Base derived = new Derived();
		System.out.println(base.str + derived.str);
		System.out.println(derived.getClass());
	}
}
