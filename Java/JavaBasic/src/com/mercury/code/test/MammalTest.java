package com.mercury.code.test;

import com.mercury.code.*;

public class MammalTest {
	public static void main(String[] args) {
		Mammal h = new Horse();
		Cattle c = new Horse();
		c.eat(h);
	}
}
