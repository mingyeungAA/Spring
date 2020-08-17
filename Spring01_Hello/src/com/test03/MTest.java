package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		//기존방식
		//1.
		//Resource res = new FileSystemResource("src/com/test03/beans.xml);
		//2.
		//Resource res = new ClassPathResource("com/test03/beans.xml");
		//BeanFactory factory = new XmlBeanFactory(res);
		
		
		//최근방식
		//3.
		//어떤 경로에 xml이 있는데 그거 읽어다가 applicationcontext만들거다 ("com/test03...")경로에서 
		//저 경로에 있는 애들을 객체로 만듬
		//applicationcontext는 beanfactory를 상속받음
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean english = (MessageBean)factory.getBean("bean01");  //object로 만든다.(명시적형변환필요)
		english.sayHello("Spring");
		
		MessageBean korean = (MessageBean)factory.getBean("bean02");
		korean.sayHello("스프링");
		
	}
	
}

/*
 * BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext
 * 
 * 스프링의 ApplicationContext 객체는 스프링 컨테이너 인스턴스이다.
 * 스프링은 ApplicationContext 인터페이스의 여러 객체를 제공한다.
 * ClassPathXmlApplicationContext : 지정된 ClassPath에서 Xml파일을 읽어서 bean을 생성
 * 
 * 
 */
