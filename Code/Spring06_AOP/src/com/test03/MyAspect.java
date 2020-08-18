package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());  //target의 클래스
		System.out.println(join.getSignature().getName());  //그 클래스에서 어떤 매소드가 호출됏는지
		System.out.println("출석카드를 찍는다.");
	}
	
	public void after() {
		System.out.println("집에 간다.");
	}

}
