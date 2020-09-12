package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;

public interface BoardDao {
	
	String NAMESPACE="com.board.";
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int mno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int mno);
	
	public String test();

}
