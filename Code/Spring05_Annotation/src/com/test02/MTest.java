package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		School school = factory.getBean("school", School.class);
		System.out.println(school);
		
	}
}
