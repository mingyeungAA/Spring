package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private MemberBiz memberBiz;
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping(value="/loginform.do")
	public String loginForm() {
		logger.info("[loginform.do]");
		
		return "loginform";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session){
		logger.info("[ajaxlogin.do]");
		
		MemberDto res = memberBiz.login(dto);
		
		boolean check = false;
		
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping("/registform.do")
	public String registForm() {
		logger.info("[registform.do]");
		
		
		return "registform";
	}
	
	@RequestMapping("/registres.do")
	public String registRes(Model model, MemberDto dto) {
		logger.info("[registres.do]");
		
		int res = memberBiz.regist(dto);
		
		if(res > 0) {
			return "redirect:loginform.do";
		}
		
		return "redirect:registform.do";
	}

}
