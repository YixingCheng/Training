package com.mercury.code.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mercury.code.MySingle;

public class TestMySingle2 {

	@Test
	public void test() {
		for (int i=0; i<10; i++){
			new Thread(){
				@Override
				public void run(){
					MySingle.getInstance();
				}
			}.start();
		}
	}

}
