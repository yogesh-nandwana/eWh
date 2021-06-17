package com.na.ewh.repositroy;

import org.springframework.data.repository.CrudRepository;

import com.na.ewh.model.GodownInfo;

public interface IGodownRepository extends CrudRepository<GodownInfo, Long> { 

}