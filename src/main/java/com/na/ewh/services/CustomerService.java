package com.na.ewh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.ewh.model.Customer;
import com.na.ewh.repositroy.ICustomerRepository;

@Service
public class CustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	public Iterable<Customer> getCustomers(){
		Iterable<Customer> customers = customerRepository.findAll();
		return customers;
	}
}