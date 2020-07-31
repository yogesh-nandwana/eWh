package com.na.ewh.repositroy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.na.ewh.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long> { 

}