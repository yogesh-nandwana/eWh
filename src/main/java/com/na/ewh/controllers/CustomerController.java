package com.na.ewh.controllers;

import java.security.Principal;

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
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public String getAllCustomers(Model m,Principal principal) {
		Iterable<CustomerInfo> customers = customerService.getCustomers();
		log.info("/customers request by user:{}",principal.getName());
		
		m.addAttribute("customers", customers);
		
		return "customers";
	}
	
	@GetMapping("/addcustomer")
	public String showAddCustomerForm(Model m,Principal principal) {
		log.info("/addcustomer request by user:{}",principal.getName());
		CustomerInfo customerInfo = new CustomerInfo();
		AddressInfo addressInfo = new AddressInfo();
		
		ContactInfo contactInfo = new ContactInfo();
		
		customerInfo.setAddressInfo(addressInfo);
		customerInfo.setContactInfo(contactInfo);
		
		m.addAttribute("customerInfo",customerInfo);
		return "addcustomer";
	}
	
	@PostMapping("/savecustomer")
	public String saveCustomer(@Valid CustomerInfo customerInfo,Errors errors,Principal principal) {
		log.info("/savecustomer request by user:{}",principal.getName());
		if (errors.hasErrors()) {
			return "addcustomer";
		}
		customerInfo.setRegistrationDate(new java.sql.Date(System.currentTimeMillis()));
		customerService.saveCustomer(customerInfo);
		
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/update/{id}")
	public String showUpdateCustomerForm(@PathVariable final Long id,Model m,Principal principal) {
		log.info("/customers/update request by by user:{}",principal.getName());
		CustomerInfo customerInfo = customerService.findCustomer(id);
		m.addAttribute("customerInfo", customerInfo);
		return "updatecustomer";
	}
	
	@PostMapping("/updatecustomer")
	public String updateCustomer(@Valid CustomerInfo customerInfo,Errors errors,Principal principal) {
		log.info("/updatecustomer request by user:{}",principal.getName());
		if (errors.hasErrors()) {
			return "updatecustomer";
		}
		
		//setting back address id and contact id as existing(i.e. equal to customer's id)
		customerInfo.getAddressInfo().setId(customerInfo.getId());
		customerInfo.getContactInfo().setId(customerInfo.getId());
		
		customerService.saveCustomer(customerInfo);
		
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable final Long id,Principal principal) {
		log.info("delete customer request by user:{}",principal.getName());
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}
}