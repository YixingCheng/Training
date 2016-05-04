package com.mercury.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.stereotype.beans.Address;
import com.mercury.stereotype.beans.Student;

public class StereoTypeTest {
	private ApplicationContext actx;

	@Before
	public void setUp() throws Exception {
		actx = new ClassPathXmlApplicationContext("stereoconfig.xml");
	}

	@Test
	public void test() {
		Student student = (Student) actx.getBean("student");
		assertEquals(10, student.getSid());
		assertEquals("Jason", student.getName());
		Address address = student.getAddress();
		assertFalse(address==null);
		assertEquals("Princeton", address.getCity());
		assertEquals("NJ", address.getState());
		assertFalse(address.getEmails()==null);
		address.getEmails().forEach(u -> System.out.println(u));
	}

}
