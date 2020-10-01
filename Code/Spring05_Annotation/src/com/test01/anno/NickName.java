package com.test01.anno;

import org.springframework.stereotype.Component;

// <bean id="nickName" class="com.test01.anno.NickName"/> 
// 자동으로 빈객체로 만들어줌
@Component
public class NickName {
	
	public String toString() {
		return "밍";
	}

}
