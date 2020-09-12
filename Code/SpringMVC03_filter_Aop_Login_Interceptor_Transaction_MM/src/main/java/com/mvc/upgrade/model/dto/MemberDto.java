package com.mvc.upgrade.model.dto;

public class MemberDto {
	
	private int memno;
	private String memid;
	private String mempw;
	private String memname;
	
	public MemberDto() {
		
	}
	public MemberDto(int memno, String memid, String mempw, String memname) {
		this.memno=memno;
		this.memid=memid;
		this.mempw=mempw;
		this.memname=memname;
	}
	
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno=memno;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	

}
