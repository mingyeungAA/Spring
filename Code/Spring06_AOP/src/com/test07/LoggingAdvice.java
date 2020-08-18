package com.test07;


	
	import org.aopalliance.intercept.MethodInterceptor;
	import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

	public class LoggingAdvice implements MethodInterceptor { //메소드 가로채기

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			
			String methodName = invocation.getMethod().getName();
			
			StopWatch timer = new StopWatch();
			timer.start(methodName);
			System.out.println("[LOG]Method : "+methodName+" is Calling");
			Object obj = invocation.proceed();
			timer.stop();
			System.out.println("[LOG]Mtehod : "+methodName+" was Called");
			System.out.println("[LOG]Time : "+timer.getTotalTimeSeconds()+" sec");
			
			return obj;
		}

	}


