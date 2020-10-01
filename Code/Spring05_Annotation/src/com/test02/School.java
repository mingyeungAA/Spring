package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	@Autowired
	@Qualifier("joo")
	private Student student;
	private int grade;
	
	public School() {}
	
	public School(Student student, int grade) {
		super();
		this.student = student;
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return student+"\t"+grade;
	}
	

}
