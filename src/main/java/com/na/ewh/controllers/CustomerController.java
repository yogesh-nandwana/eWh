package com.na.ewh.controllers;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.na.ewh.model.CustomerInfo;
import com.na.ewh.services.CustomerService;

@Controller
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public String getAllCustomers(Model m) {
		Iterable<CustomerInfo> customers = customerService.getCustomers();
		log.info("/customers request arrived for userId");
		m.addAttribute("customers", customers);
		return "customers";
	}
	
	@GetMapping("/addcustomer")
	public String addCustomer() {
		log.info("/addcustomer request arrived for userId");
		return "addcustomer";
	}
}