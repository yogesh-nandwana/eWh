package com.na.ewh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.na.ewh.model.LoginForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String showHomePage(LoginForm loginForm) {
		log.info("/ request arrived.");
		return "home";
	}
}