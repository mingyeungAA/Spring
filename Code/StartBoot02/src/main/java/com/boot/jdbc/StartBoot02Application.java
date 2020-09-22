package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class StartBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot02Application.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
