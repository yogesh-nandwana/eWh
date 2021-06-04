package com.na.ewh.controllers;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.na.ewh.model.*;
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
	
	@GetMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable final Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/update/{id}")
	public String updateCustomer(@PathVariable final Long id,Model m) {
		CustomerInfo cust = customerService.findCustomer(id);
		m.addAttribute("customerInfo", cust);
		return "redirect:/addcustomer";
	}
	
	@GetMapping("/addcustomer")
	public String addCustomer(Model m) {
		log.info("/addcustomer request arrived for userId");
		
		CustomerInfo customerInfo = new CustomerInfo();
		AddressInfo addressInfo = new AddressInfo();
		
		ContactInfo contactInfo = new ContactInfo();
		
		customerInfo.setAddressInfo(addressInfo);
		customerInfo.setContactInfo(contactInfo);
		
		m.addAttribute("customerInfo",customerInfo);
		
		return "addcustomer";
	}
	
	@PostMapping("/savecustomer")
	public String addCustomer(@Valid CustomerInfo customerInfo,Errors errors) {
		log.info("/savecustomer request arrived");
		if (errors.hasErrors()) {
			return "addcustomer";
		}
		customerInfo.setRegistrationDate(new java.sql.Date(System.currentTimeMillis()));
		customerService.saveCustomer(customerInfo);
		
		return "redirect:/customers";
	}
}