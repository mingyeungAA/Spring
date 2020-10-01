package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		//스프링 컨테이너 생성 및 설정
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		//스프링 컨테이너 사용
		MyNickNamePrn nick = factory.getBean("myNickNamePrn",MyNickNamePrn.class);
		System.out.println(nick);
		
		//스프링 컨테이너 종료
		((ClassPathXmlApplicationContext)factory).close();
	}

}
