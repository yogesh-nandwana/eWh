package com.na.ewh.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import com.na.ewh.model.LoginForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@PostMapping("/login")
	public String showLoginPage(@Valid LoginForm loginForm,Errors errors) {
		if (errors.hasErrors()) {
			return "home";
		}
		String userId = loginForm.getUserId();
		String pwd = loginForm.getPwd();
		log.info("/login request arrived for userId:"+userId);
		if("test".equals(userId) && "test123".equals(pwd)) {
			log.info("user:"+userId+" logged in successful, redirecting to welcome page.");
			return "welcome";
		}else {
			log.info("user:"+userId+" logged in failed, redirecting back to home page.");
			return "home";
		}		
	}
}