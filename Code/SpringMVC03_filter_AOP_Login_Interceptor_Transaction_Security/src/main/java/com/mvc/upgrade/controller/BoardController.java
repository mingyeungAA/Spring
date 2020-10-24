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
		
		model.addAttribute("list", boardBiz.selectList());
		
		return "mvclist";
	}
	
	@RequestMapping(value="/detail.do")
	public String selectOne(Model model, int myno) {
		logger.info("[detail.do]");
		
		model.addAttribute("dto", boardBiz.selectOne(myno));
		
		return "mvcdetail";
	}
	
	@RequestMapping(value="/insert.do")
	public String insert() {
		
		return "mvcinsert";
	}
	
	@RequestMapping(value="/insertres.do")
	public String insertres(Model model, BoardDto dto) {
		logger.info("[insertres.do]");
		
		int res = boardBiz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		}
				
		return "mvcinsert";
	}
	
	@RequestMapping(value="/update.do")
	public String update(Model model, int myno) {
		logger.info("[update.do]");
		
		BoardDto dto = boardBiz.selectOne(myno);
		
		model.addAttribute("dto", dto);
		
		return "mvcupdate";
	}
	
	@RequestMapping(value="/updateres.do")
	public String updateres(Model model, BoardDto dto, int myno) {
		logger.info("[updateres.do]");
		int res = boardBiz.update(dto);
		
		if(res > 0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}
		
		return "redirect:update.do?myno="+dto.getMyno();
	}
	
	@RequestMapping(value="/delete.do")
	public String delete(Model model, int myno) {
		logger.info("[delete.do]");
		
		int res = boardBiz.delete(myno);
		
		if(res > 0) {
			return "redirect:list.do";
		}
		return "redirect:detail.do?myno="+myno;
	}
	
	@RequestMapping("/test.do")
	public String transactionTest() {
		logger.info("[test.do]");
		
		boardBiz.transactionTest();
		
		return "redirect:list.do";
	}

}
