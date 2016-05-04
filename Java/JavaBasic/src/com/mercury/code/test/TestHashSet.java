package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.mercury.code.WrappedString;


public class TestHashSet {

	@Test
	public void test() {
		Set<Object> set = new HashSet<Object>();
		set.add(new WrappedString("abc"));
		set.add(new WrappedString("abc"));
		set.add(new String("abc"));
		set.add(new String("abc"));   //overriden the hashcode() and equals() of String Class
		assertEquals(2, set.size());
	}
	
	@Test
	public void test1(){
		
	}

}
