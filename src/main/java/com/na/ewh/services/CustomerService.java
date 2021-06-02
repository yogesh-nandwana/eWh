package com.na.ewh.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.ewh.model.CustomerInfo;
import com.na.ewh.repositroy.ICustomerRepository;

@Service
public class CustomerService {
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	ICustomerRepository customerRepository;

	public Iterable<CustomerInfo> getCustomers(){
		log.info("Inside getCustomers()");
		Iterable<CustomerInfo> customers = customerRepository.findAll();
		return customers;
	}
	
	public void saveCustomer(CustomerInfo customer) {
		log.info("Inside saveCustomer() for customer:",customer.getName());
		customer.getAddressInfo().setCustomer(customer);
		customer.getContactInfo().setCustomer(customer);
		customerRepository.save(customer);
		log.info("Customer details saved for:",customer.getName());
	}
}