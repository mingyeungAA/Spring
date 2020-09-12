package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int mno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int mno);

	public String transactionTest();
}
