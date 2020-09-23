package com.boot.leaf.model.dto;

public class LeafDto {
	
	private String subject;
	private int seq;
	
	public LeafDto() {
		
	}
	public LeafDto(String subject, int seq) {
		this.subject=subject;
		this.seq=seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	

}
