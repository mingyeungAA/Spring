package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;

public interface BoardDao {
	
	//맨마지막에 . 잊지말기!!!
	//mapper의 namespace와 같다!
	String NAMESPACE="com.mvc.upgrade.myboard.";
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	
	public String test();

}
