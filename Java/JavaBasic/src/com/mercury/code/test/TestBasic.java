package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.mercury.code.BeanA;
import com.mercury.code.BeanB;

public class TestBasic {
	

	@Test
	public void test1() {
		int x = 1;
		boolean b = false;
		if (b && ++x>1 ){
			//do something
		} else{
			
		}
		assertEquals(1, x);
	}

	@Test
	public void test2(){
		int[] array = {8, 5, 1, 3, 2, 4, 6, 7};
		Arrays.sort(array);
		for (int i=0; i< array.length; i++){
			assertEquals(i+1, array[i]);
		}
	}
	
	@Test
	public void testSwitch(){
		String result = "";
		int x=1;    //long x= 5
		switch (x){
		//default: result +="Z"; 
		case 1: result += "A";
		case 2: result +="B"; break;
		case 3: result +="C"; 
		default: result +="Z"; 
		}
		System.out.println(result);
		assertEquals("ZABC", result);
		assertNotSame("ZABC", result);
	}
	
	@Test
	public void testSwitch2(){
		String option = "C";
		int x = 0;
		switch (option){
		default: x += 100;
		case "A": x+=1;
		case "B": x+=2;
		case "C": x+=3; break; 
		}
		assertEquals(5, x);
	}
	
	@Test
	public void test3(){
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		assertEquals(s1, s2);    //assertEquals compare .equals()
		assertEquals(s1, s3);
		assertSame(s1, s2);      // s1 == s2 is true
		assertTrue(s1==s2);
		assertNotSame(s1, s3);   // s1 == s3 is false
		assertFalse(s1==s3);
		assertSame(s1, s3.intern());
		assertTrue(inPool(s1));
		assertFalse(inPool(s3));
	}
	
	private boolean inPool(String str){
		return str==str.intern();
	}
	
	
	private void change(String str){
		str = "change";
	}
	
	@Test
	public void test4() {
		String str = "abc";
		change(str);
		assertEquals("abc", str);
	}
	
	private String getNumber(Short x){
		return x + " in Short";
	}
	private String getNumber(Long x){    //autoboxing
		return x + " in Long";
	}
	private String getNumber(int x){     //short is cast to int
		return x + " in int";
	}
	
	@Test
	public void test5(){
		short x = 5;
		assertEquals("5 in int", getNumber(x));
		Short y = 6;
		assertEquals("6 in Short", getNumber(y));
		long z = 7;
		assertEquals("7 in Long", getNumber(z));
	}
	
	@Test
	public void test6(){
		Integer x = 10;
		Integer y = 10;
		assertEquals(x, y);
		assertSame(x, y);   // x == y is true
		Integer u = 1000;
		Integer v = 1000;
		assertEquals(u, v);
		assertNotSame(u, v);  // u == v is not true
	}
	
	@Test(expected=ArithmeticException.class)
	public void test7(){
		int x = 5;
		int y = 0;
		System.out.println(x/y);
	}
	
	@Test
	public void test8(){
		Object obj = new Object();
		System.out.println(obj.toString());
	}
	
	@Test
	public void test9(){
		String s1 = "ab";
		String s2 = s1 + "cd";
		String s3 = "ab" + "cd";
		assertFalse(s2 == s3);
	}
	
	@Test
	public void test10(){
		BeanA b1 = new BeanA();
		BeanA b2 = new BeanA();
		assertSame(b1.getBase(), b2.getBase());
	}
	
}
