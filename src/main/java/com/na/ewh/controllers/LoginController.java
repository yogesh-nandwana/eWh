package com.na.ewh.controllers;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import com.na.ewh.model.LoginForm;

//@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/login")
	public String showLoginPage(@Valid LoginForm loginForm,Errors errors) {
		if (errors.hasErrors()) {
			return "home";
		}
		String userId = loginForm.getUserId();
		String pwd = loginForm.getPwd();
		log.info("/login request by user:"+userId);
		if("test".equals(userId) && "test123".equals(pwd)) {
			log.info("user:"+userId+" logged in successful, redirecting to customers page.");
			return "redirect:/customers";
		}else {
			log.info("user:"+userId+" logged in failed, redirecting back to home page.");
			return "home";
		}		
	}
}