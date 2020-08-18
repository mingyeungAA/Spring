package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Before("qClass()")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	@After("qClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	@Pointcut("execution(public * *(..))")
	public void qClass() {  //빈 클래스  => qClass 이름으로 pointcut을 대신하겟따.
		
	}
	
}
