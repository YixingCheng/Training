package com.mercury.code.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mercury.code.Employee;

public class TestEmployee {
    private Employee emp;
	
	@Before
	public void setUp() throws Exception {
		emp = new Employee("Bob");
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		Employee emp2 = emp.clone();
		assertNotSame(emp, emp2);
		assertSame(emp.getName(), emp2.getName());      //why is the same 
		assertEquals(emp.getName(), emp2.getName());
	}

}
