package com.mercury.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mercury.beans.MultiCollection;
import com.mercury.beans.Person;
import com.mercury.beans.User;
import com.mercury.beans.Wrapper;

public class IoCTest {
	private ApplicationContext actx;

	@Before
	public void setUp() throws Exception {
		actx = new FileSystemXmlApplicationContext("resource/iocconfig.xml");
	}

	@Test
	public void testSetterInjection() {
		User user = (User) actx.getBean("user");
		assertEquals("Mary", user.getName());
		assertEquals(70, user.getAge());
		User user2 = (User) actx.getBean("user");
		assertNotSame(user, user2);  //singleton?
		
		assertSame(user.getName(), user2.getName());
	}
	
	@Test
	public void testConstructorInjection(){
		Person person = (Person) actx.getBean("person");
		assertEquals("Bruce", person.getFirstName());
		assertEquals("Lee", person.getLastName());
		assertEquals(30, person.getAge());
	}
	
	@Test
	public void testComplexInjection(){
		Wrapper wrapper = (Wrapper) actx.getBean("wr");
		User user = wrapper.getUser();
		assertEquals("Mary", user.getName());
		assertEquals(70, user.getAge());
		Person person = wrapper.getP();
		assertEquals("Bruce", person.getFirstName());
		assertEquals(30, person.getAge());
		User user2 = (User) actx.getBean("user");
		assertNotSame(user, user2);                   //scope
		Person person2 = (Person) actx.getBean("person");
		assertSame(person, person2);
	}
	
	@Test
	public void testAutowire(){
		Wrapper wrapper = (Wrapper) actx.getBean("wr2");
		assertFalse(wrapper.getUser() == null);
		assertTrue(wrapper.getP() == null);
		Wrapper wrapper3 = (Wrapper) actx.getBean("wr3");
		assertFalse(wrapper3.getUser() == null);
		assertFalse(wrapper3.getP() == null);
	}
	
	@Test
	public void testInjectionForCollection(){
		MultiCollection mc = (MultiCollection) actx.getBean("mc");
		mc.getList().forEach(u-> System.out.println(u));
		
		mc.getMap().forEach((k, v)-> System.out.println(k));
	}
}
