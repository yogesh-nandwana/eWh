package com.na.ewh.repositroy;

import org.springframework.data.repository.CrudRepository;

import com.na.ewh.model.CommodityInfo;

public interface ICommodityRepository extends CrudRepository<CommodityInfo, Long> { 

}