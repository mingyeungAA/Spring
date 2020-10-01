package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//class와 똑같은 이름을 쓴다(첫글자는 소문자로)
// <bean id="myNickNamePrn" class="com.test01.anno.MyNickNamePrn" />
//MyNickNamePrn을 빈(객체)으로 만들겨
@Component
public class MyNickNamePrn {
	
	// autowire = "default"의 기능과 비슷하게 동작
	@Autowired
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}
	
	public String toString() {
		return "내 별명은 " + nickName + "입니다.";
	}
	
}
