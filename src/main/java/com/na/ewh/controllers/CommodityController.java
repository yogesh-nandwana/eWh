package com.na.ewh.controllers;

import java.security.Principal;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
