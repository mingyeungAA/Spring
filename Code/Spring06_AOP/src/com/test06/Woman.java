package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {

	
	@Override
	public void classWork() {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터를 켜서 쇼핑한다.");
	}

}
