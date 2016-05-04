package com.mercury.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TimeBookInterface;

public class AspectJTest {
public static void main(String[] args){
		
		ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
		TimeBookInterface tb = (TimeBookInterface) actx.getBean("timeBook");
		System.out.println(tb.getClass().getName());
		//the tb object does not need to be the TimeBook object, 
		tb.doAudit("Alice");
		tb.doBreak("Bob");
		try{
			tb.doCheck("Steven");
		} catch (Exception e){
			System.out.println(e);
		}
		try{
			tb.doDelete(20);
			tb.doDelete(200);
		} catch(Exception e){
			System.out.println(e);
		}
	}

}
