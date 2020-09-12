package com.mvc.upgrade.model.dto;

import java.util.Date;

public class BoardDto {
	
	private int mno;
	private String name;
	private String title;
	private String content;
	private Date mdate;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int mno, String name, String title, String content, Date mdate) {
		this.mno=mno;
		this.name=name;
		this.title=title;
		this.content=content;
		this.mdate=mdate;
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno=mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	

}
