package com.mercury.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.Address;
import com.mercury.beans.Apartment;
import com.mercury.beans.Employee;
import com.mercury.beans.LazyBean;
import com.mercury.beans.MySingle;

public class IoCTest2 {
	private static ApplicationContext actx;

	@BeforeClass
	public static void setUp() throws Exception {
		actx = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("Set up finished");
	}

	@Test
	public void test() {
		Employee emp = (Employee) actx.getBean("emp");
		assertEquals(100, emp.getId());
		assertEquals("Alice", emp.getName());
		Address address = emp.getAddress();
		assertEquals("Plainsboro", address.getCity());
		assertEquals("NJ", address.getState());
		assertEquals("08536", address.getZipCode());
	}
	
	@Test
	public void testSubClassInjection(){
		Apartment apt= (Apartment) actx.getBean("apt");
		assertEquals(615, apt.getAptNo());
		assertEquals("Plainsboro", apt.getCity());
		assertEquals("NJ", apt.getState());
		assertEquals("08536", apt.getZipCode());
		Address gh = (Address) actx.getBean("guestHouse");
		assertEquals("Plainsboro", gh.getCity());
		assertEquals("NJ", gh.getState());
		assertEquals("08536", gh.getZipCode());
		assertEquals("Quail Ridge Rd", gh.getStreet());
		
	}
	
	@Test
	public void testSingletonInjection(){
		MySingle ms = (MySingle) actx.getBean("ms");
		MySingle ms2 = (MySingle) actx.getBean("ms");
		assertSame(ms, ms2);
		MySingle ms3 = MySingle.getInstance();  
		assertSame(ms, ms3);
	}

	@Test
	public void testLazyBean(){
		assertEquals(0, LazyBean.getCounter());
		actx.getBean("lazyBean");
		assertEquals(1, LazyBean.getCounter());
	}
}
