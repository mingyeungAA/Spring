package com.mvc.update.biz;

import java.util.List;

import com.mvc.update.dto.JDBCDto;


public interface JDBCBiz {
	
	public List<JDBCDto> selectList();
	public JDBCDto selectOne(int seq);
	public int insert(JDBCDto dto);
	public int update(JDBCDto dto);
	public int delete(int seq);

}
