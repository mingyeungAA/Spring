package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor { //메소드 가로채기

	//ccc(공통사항)
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object target = null;
		
		System.out.println("출석카드를 찍는다.");
		
		try {
			target = invocation.proceed();
		} catch (Throwable e) {
			System.out.println("쉬는 날이었다.");
		}
		
		System.out.println("집에 간다.");
		
		return target;
	}

}
