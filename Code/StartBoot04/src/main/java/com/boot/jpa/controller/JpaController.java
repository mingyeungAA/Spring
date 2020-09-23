package com.boot.jpa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.dto.JpaDto;

@Controller
@RequestMapping("/member")
public class JpaController {
	
	@Autowired
	private JpaDao jpaDao;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list",jpaDao.findAll());
		return "jpalist";
	}
	
	@GetMapping("/insertform")
	public String insert() {
		
		return "jpainsert";
	}
	
	@PostMapping("/insertres")
	public String insertRes(JpaDto dto) {
		dto.setMydate(new Date());
		jpaDao.save(dto);
		
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", jpaDao.findByMyno(myno));
		
		return "jpadetail";
	}
	
	@GetMapping("/updateform")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", jpaDao.findByMyno(myno));
		
		return "jpaupdate"; 
	}
	
	@PostMapping("/updateres")
	public String updateRes(JpaDto dto) {
		
		jpaDao.saveAndFlush(dto);
		
		return "redirect:detail?myno="+dto.getMyno();
	}
	
	@GetMapping("delete")
	public String delete(int myno) {
		
		jpaDao.deleteByMyno(myno);
		
		return "redirect:list";
	}
}
