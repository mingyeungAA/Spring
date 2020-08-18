package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {

	@Override
	public void classWork() {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터를 켜서 축구를 본다.");
	}

}
