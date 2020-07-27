package com.na.ewh.repositroy;

import org.springframework.data.repository.CrudRepository;

import com.na.ewh.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> { 

}
