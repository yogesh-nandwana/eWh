package com.na.ewh.controllers;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.na.ewh.model.LoginForm;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String showHomePage(LoginForm loginForm) {
		log.info("/ request. Redirecting to /customers");
		return "redirect:/customers";
	}
}