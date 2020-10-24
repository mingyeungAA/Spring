package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		
		return dao.delete(myno);
	}
	
	//@Transactional : 자동으로 커밋,롤백 해줌
	@Transactional
	@Override
	public String transactionTest() {  //Transaction : All or Nothing
		dao.insert(new BoardDto(0, "transaction", "test", "insert", null));
		
		//이 아래 두줄이 예외발생하면 윗줄한줄도 취소되어야됨!
		String test = dao.test();
		//->NullPointerException 에러 발생한다!
		test.length(); 
		
		return test;
	}

}
