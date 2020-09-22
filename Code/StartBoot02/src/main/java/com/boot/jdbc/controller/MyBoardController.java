package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {
	
	@Autowired
	private MyBiz myBiz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list", myBiz.selectList());
		
		return "bootlist";
	}
	
	@GetMapping("/insert")
	public String insert() {
		
		
		return "bootinsert";
	}
	
	@PostMapping("/insertres")
	public String insertRes(MyDto dto) {
		
		int res = myBiz.insert(dto);
		if(res > 0) {
			return "redirect:list";
		}
		
		return "bootinsert";
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", myBiz.selectOne(myno));
		
		return "bootdetail";
	}
	
	@GetMapping("/update")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", myBiz.selectOne(myno));
		
		return "bootupdate";
	}
	
	@PostMapping("/updateres")
	public String updateRes(MyDto dto) {
		
		int res = myBiz.update(dto);
		if(res > 0) {
			return "redirect:detail?myno="+dto.getMyno();
		}
		
		return "redirect:update?myno="+dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		int res = myBiz.delete(myno);
		if(res > 0) {
			return "redirect:list";
		}
		
		return "redirect:detail?myno="+myno;
	}

}
