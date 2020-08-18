package com.test04;

public class Man implements Person {

	
	//cc(target)
	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 축구를 본다.");
		//String s = null;
		//s.length();
		/*위에 두줄을 추가하면
	             예외가 발생한다. (@After-Throwing "쉬는날이었다" 출력됨)
	    */
		
		return "spring";
	}

}
