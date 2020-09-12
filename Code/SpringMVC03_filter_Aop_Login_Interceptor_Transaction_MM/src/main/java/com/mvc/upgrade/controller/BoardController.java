package com.mvc.upgrade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz boardBiz;
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

		
	@RequestMapping(value="/list.do")
	public String selectList(Model model) {
		logger.info("[list.do]");
		
		model.addAttribute("list",boardBiz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int mno) {
		logger.info("[detail.do]");
		
		model.addAttribute("dto", boardBiz.selectOne(mno));
		
		return "boarddetail";
	}
	
	@RequestMapping("/insert.do")
	public String insert() {
		logger.info("[insert.do]");
		
		return "boardinsert";
	}
	
	@RequestMapping(value="/insertres.do")
	public String insertRes(Model model, BoardDto dto) {
		logger.info("[insertres.do]");
		
		int res = boardBiz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:insert.do";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model, int mno) {
		logger.info("[update.do]");
		
		model.addAttribute("dto", boardBiz.selectOne(mno));
		
		return "boardupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(Model model, BoardDto dto) {
		logger.info("[updateres.do]");
		
		int res = boardBiz.update(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:update.do?mno="+dto.getMno();
	}
	
	@RequestMapping(value="/delete.do")
	public String delete(Model model, int mno) {
		logger.info("[delete.do]");
		
		int res = boardBiz.delete(mno);
		
		if(res > 0) {
			return "redirect:list.do";
		}
		return "redirect:detail.do?mno="+mno;
	}
	
	//Transaction
	@RequestMapping("/test.do")
	public String transactionTest() {
		logger.info("[test.do]");
		
		boardBiz.transactionTest();
		
		return "redirect:list.do";
	}
	
}
