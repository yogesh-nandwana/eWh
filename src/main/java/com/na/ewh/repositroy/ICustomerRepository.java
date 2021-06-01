package com.na.ewh.repositroy;

import org.springframework.data.repository.CrudRepository;
import com.na.ewh.model.CustomerInfo;

public interface ICustomerRepository extends CrudRepository<CustomerInfo, Long> { 

}