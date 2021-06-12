package com.na.ewh.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.na.ewh.model.CommodityInfo;
import com.na.ewh.services.CommodityService;

@Controller
public class CommodityController {
	private static final Logger log = LoggerFactory.getLogger(CommodityController.class);
	
	@Autowired
	private CommodityService commodityService;
	
	@GetMapping("/commodities")
	public String getAllCommodities(Model m,Principal principal){
		Iterable<CommodityInfo> commodities = commodityService.getCommodities();
		log.info("/commodities request arrived by user:{}",principal.getName());
		
		m.addAttribute("commodities", commodities);
		
		return "commodities";
	}
	
	@GetMapping("/addcommodity")
	public String showAddCommodityForm(Model m,Principal principal) {
		log.info("/addcommodity request arrived by user:{}",principal.getName());
		
		CommodityInfo commodityInfo = new CommodityInfo();
		
		m.addAttribute("commodityInfo",commodityInfo);
		return "addcommodity";
	}
	
	@PostMapping("/savecommodity")
	public String saveCommodity(@Valid CommodityInfo commodityInfo,Errors errors,Principal principal) {
		log.info("/saveCommodity request by user:{}",principal.getName());
		if(errors.hasErrors()) {
			return "addcommodity";
		}
		commodityService.saveCommodity(commodityInfo);
		return "redirect:/commodities";
	}
}
