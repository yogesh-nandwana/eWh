package com.na.ewh.controllers;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		log.info("/customers request arrived");
		m.addAttribute("customers", customers);
		return "customers";
	}
	
	@GetMapping("/addcustomer")
	public String addCustomer(Model m) {
		log.info("/addcustomer request arrived for userId");
		m.addAttribute("customerInfo", new CustomerInfo());
		return "addcustomer";
	}
	
	@PostMapping("/savecustomer")
	public String addCustomer(@Valid CustomerInfo customerInfo,Errors errors) {
		log.info("/savecustomer request arrived");
		if (errors.hasErrors()) {
			return "addcustomer";
		}
		String firstName = customerInfo.getFirstName();
		String lastName = customerInfo.getLastName();
		return "redirect:/customers";
	}
}