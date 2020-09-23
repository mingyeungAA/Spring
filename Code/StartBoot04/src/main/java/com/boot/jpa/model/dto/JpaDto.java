package com.boot.jpa.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
;

//MYBOARD의 테이블과 JpaDto가 연결된다.
@Entity  //테이블로 만들고 싶은 객체
@Table(name="MYBOARD")  //MYBOARD라는 테이블과 연결됨
public class JpaDto {
	
	@Id  //primary key설정
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)  //auto : hibernate가 sequence까지 자동으로 만들어서 값을  넣어준다.
	private int myno;
	
	@Column
	private String myname;
	
	@Column
	private String mytitle;
	
	@Column
	private String mycontent;
	
	@Column(updatable=false)
	@Temporal(TemporalType.DATE)  //날짜 형식 바꿔주는
	private Date mydate;
	
	
	public JpaDto() {}
	
	public JpaDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
	
}
