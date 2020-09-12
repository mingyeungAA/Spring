package com.mvc.upgrade.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MemberDao;
import com.mvc.upgrade.model.dto.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public MemberDto login(MemberDto dto) {
	
		return memberDao.login(dto);
	}

	@Override
	public int regist(MemberDto dto) {
		
		return memberDao.regist(dto);
	}

}
