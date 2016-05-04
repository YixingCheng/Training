package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.mercury.code.BeanA;
import com.mercury.code.BeanB;

public class TestComparison {

	@Test
	public void testComparable() {
		List<BeanA> list = new ArrayList<>();
		list.add(new BeanA(5));
		list.add(new BeanA(3));
		list.add(new BeanA(7));
		assertEquals(3, list.size());
		assertEquals(5, list.get(0).getX());
		assertEquals(3, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
		Collections.sort(list);
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
	}

	@Test
	public void testComparator() {
		List<BeanB> list = new ArrayList<>();
		list.add(new BeanB(5));
		list.add(new BeanB(3));
		list.add(new BeanB(7));
		assertEquals(3, list.size());
		assertEquals(5, list.get(0).getX());
		assertEquals(3, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
		Collections.sort(list, new Comparator<BeanB>(){
			@Override
			public int compare(BeanB first, BeanB second){
				return first.getX() - second.getX();
			}
		});
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
	}
	
	@Test(expected=ConcurrentModificationException.class)
	public void testFailFastIterator(){
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		Iterator<String> it = list.iterator();
		list.add("D"); list.remove("D");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
}
