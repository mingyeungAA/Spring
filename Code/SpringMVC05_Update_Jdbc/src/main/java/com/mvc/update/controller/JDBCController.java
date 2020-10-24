package com.mvc.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.biz.JDBCBiz;

@Controller
public class JDBCController {
	
	@Autowired
	private JDBCBiz jdbcBiz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", jdbcBiz.selectList());
		
		return "jdbclist";
	}

}
