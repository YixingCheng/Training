package com.mercury.code.test;

import java.util.HashSet;
import java.util.Set;

import com.mercury.code.KeyMaster;

public class TestKeyMaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<KeyMaster> set = new HashSet<KeyMaster>();
		KeyMaster k1 = new KeyMaster(1);
		KeyMaster k2 = new KeyMaster(2);
		set.add(k1);set.add(k1);
		set.add(k2);set.add(k2);
		System.out.println(set.size() + ":");
		k2.k = 1;
		System.out.println(set.size() + ":");
		set.remove(k1);
		System.out.println(set.size() + ":");
		set.remove(k2);
		System.out.println(set.size() + ":");
	}

}
