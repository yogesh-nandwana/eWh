package com.na.ewh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.na.ewh.model.Customer;
import com.na.ewh.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public String getAllCustomers(Model m) {
		Iterable<Customer> customers = customerService.getCustomers();
		//log.info("/customers request arrived for userId");
		m.addAttribute("customers", customers);
		return "customers";
	}
	
	@GetMapping("/addcustomer")
	public String addCustomer() {
		//log.info("/addcustomer request arrived for userId");
		return "addcustomer";
	}
}