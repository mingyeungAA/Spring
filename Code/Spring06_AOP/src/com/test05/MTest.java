package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Person man = (Person)factory.getBean("man");
		Person woman = factory.getBean("woman", Person.class);
		
		System.out.println("남학생 입장");
		man.classWork();
		System.out.println("-------");
		System.out.println("여학생 입장");
		woman.classWork();
		
	}

}
