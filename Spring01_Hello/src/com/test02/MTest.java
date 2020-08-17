package com.test02;

public class MTest {
	
	public static void main(String[] args) {
		
		MessageBean bean01 = new MessageBeanEn();
		bean01.sayHello("Spring");
		
		MessageBean bean02 = new MessageBeanKo();
		bean02.sayHello("스프링");
		
	}
}
