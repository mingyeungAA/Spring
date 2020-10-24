package com.mvc.upgrade.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	

	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login", dto);
		} catch (Exception e) {
			logger.info("[ERROR] login");
			e.printStackTrace();
		}
		
		return res;
	}


	@Override
	public int regist(MemberDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"regist", dto);
		} catch (Exception e) {
			logger.info("[ERROR] regist");
			e.printStackTrace();
		}
		return res;
	}

}
