package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//어노테이션 사용!

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석카드를 찍는다.");
	}
	
	@After("execution(public String * (..))")  //joinpoint들 중에 public void 이름 상관없고 파라미터도 상관없는 애랑 같으면 이걸 호출해줄거야
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	@AfterThrowing("execution(public * *(..))")  //예외가 발생햇을때 호출됨
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이었다.");
	}
	
	@AfterReturning(pointcut = "execution(public * *(..))", returning="returnVal") //return되는 값(=target이 주는 return값)을 returnVal에 연결해줄거야
	public void returning(JoinPoint join, Object returnVal) {  //returning : target에서 리턴되는 값을 사용할 수 있게 해주는
		System.out.println(returnVal + " 공부하는 날이었다.");
	}

}
