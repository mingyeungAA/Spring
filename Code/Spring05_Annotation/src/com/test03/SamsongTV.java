package com.test03;

import org.springframework.stereotype.Component;

@Component("samsong")
public class SamsongTV implements TV {

	@Override
	public void powerOn() {
		
		System.out.println("samsong tv power on");
	}

	@Override
	public void powerOff() {
		
		System.out.println("samsong tv power off");
	}

	@Override
	public void volumeUp() {
		
		System.out.println("samsong tv volume up");
	}

	@Override
	public void volumeDown() {
		
		System.out.println("samsong tv volume down");
	}

}
