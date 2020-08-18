package com.test01;

public class Mtest {
	public static void main(String[] args) {
		
		Man man = new Man();
		Woman woman = new Woman();
		
		
		System.out.println("남학생 입장");
		man.classWork();
		System.out.println("------------");
		System.out.println("여학생 입장");
		woman.classWork();
		
	}

}
