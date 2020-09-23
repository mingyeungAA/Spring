package com.boot.leaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.model.dto.LeafDto;

@Controller
public class LeafController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("name","민경");
		
		return "hello";
	}
	
	@GetMapping("/util")
	public String util() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String expression(Model model) {
		
		model.addAttribute("name","Thymeleaf");
		
		LeafDto dto = new LeafDto("java",1);
		model.addAttribute("dto",dto);
		
		List<LeafDto> list = new ArrayList<LeafDto>();
		list.add(new LeafDto("DataBase",2));
		list.add(new LeafDto("jsp/Servlet",3));
		model.addAttribute("list",list);
		
		return "expression";
	}
	
	@GetMapping("/params")
	public String params(Model model, HttpSession session) {
		
		model.addAttribute("dto", new LeafDto("Spring",4));
		session.setAttribute("pw", "qclass");
		
		return "params";
	}
	
	@GetMapping("/static")
	public String staticTest() {
		
		return "static";
	}

}
