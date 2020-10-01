package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		SamsongTV sm = factory.getBean("samsong", SamsongTV.class);
		IgTV ig = factory.getBean("igTV", IgTV.class);
		
		sm.powerOn();
		ig.powerOn();
		
	}

}
