package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

import com.mercury.code.BeanB;

public class TestLambda {

	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.forEach(u -> System.out.println(u));
	}
	
	@Test
	public void test2(){
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 100);
		map.put("B", 200);
		map.put("C", 300);
		map.forEach((k, v) -> System.out.println(k + ": " + v));
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
		Collections.sort(list, (u, v) -> u.getX() - v.getX());
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
	}
	
	@Test
	public void testCompute(){
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		assertEquals(10, map.get("A").intValue());
		assertEquals(null, map.get("B"));
		map.compute("A", (k, v) -> v == null ? 1: v+1);
		assertEquals(11, map.get("A").intValue());
		map.compute("B", (k, v) -> v == null ? 1: v+1);
		assertEquals(1, map.get("B").intValue());
	}
	
}
