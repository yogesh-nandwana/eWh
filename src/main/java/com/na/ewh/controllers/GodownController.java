package com.na.ewh.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.na.ewh.model.AddressInfo;
import com.na.ewh.model.ContactInfo;
import com.na.ewh.model.GodownInfo;
import com.na.ewh.services.GodownService;

@Controller
public class GodownController {
	private static final Logger log = LoggerFactory.getLogger(GodownController.class);
	
	@Autowired
	private GodownService godownService;
	
	@GetMapping("/godowns")
	public String getAllGodowns(Model m,Principal principal) {
		Iterable<GodownInfo> godowns = godownService.getGodowns();
		log.info("/godowns request by user:{}",principal.getName());
		
		m.addAttribute("godowns", godowns);
		
		return "godowns";
	}
	
	@GetMapping("/addgodown")
	public String showAddCustomerForm(Model m,Principal principal) {
		log.info("/addgodown request by user:{}",principal.getName());
		GodownInfo godownInfo = new GodownInfo();
		AddressInfo addressInfo = new AddressInfo();
		
		ContactInfo contactInfo = new ContactInfo();
		
		godownInfo.setAddressInfo(addressInfo);
		godownInfo.setContactInfo(contactInfo);
		
		m.addAttribute("godownInfo",godownInfo);
		return "addgodown";
	}
	
	@PostMapping("/savegodown")
	public String saveGodown(@Valid GodownInfo godownInfo,Errors errors,Principal principal) {
		log.info("/savegodown request by user:{}",principal.getName());
		if (errors.hasErrors()) {
			return "addgodown";
		}
		godownInfo.setOpeningDate(new java.sql.Date(System.currentTimeMillis()));
		godownService.saveGodown(godownInfo);
		
		return "redirect:/godowns";
	}
}