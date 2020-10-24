package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/loginform.do")
	public String loginForm() {
		
		logger.info("[loginform.do]");
		
		return "loginform";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		logger.info("[ajaxlogin.do]");
		
		MemberDto res = memberBiz.login(dto);
		
		boolean check = false;
		
		if(res != null) {
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {  
			//rawPassword : 사용자가 입력한 password, encodedPassword : DB에 저장된 암호화된 password
				logger.info("사용자가 전달한 memberpw : "+dto.getMemberpw());
				logger.info("db에 암호화되어 저장된 memberpw : "+res.getMemberpw());
				
				session.setAttribute("login", res);
				check = true;
			}
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping(value="/registform.do")
	public String registForm() {
		logger.info("[registform.do]");
		
		return "registform";
	}
	
	@RequestMapping(value="/registres.do")
	public String registres(Model model, MemberDto dto) {
		logger.info("[registres.do]");
		
		//비밀번호 암호화 할거임
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		logger.info("암호화된 memberpw : "+dto.getMemberpw());
		
		int res = memberBiz.regist(dto);
		
		if(res > 0) {
			return "redirect:loginform.do";
		}
		
		return "redirect:registform.do";
	}

}
