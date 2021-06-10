package com.na.ewh.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.ewh.model.CommodityInfo;
import com.na.ewh.repositroy.ICommodityRepository;

@Service
public class CommodityService {
	private static final Logger log = LoggerFactory.getLogger(CommodityService.class);
	
	@Autowired
	ICommodityRepository commodityRepository;

	public Iterable<CommodityInfo> getCommodities(){
		log.info("Inside getCommodities()");
		Iterable<CommodityInfo> commodities = commodityRepository.findAll();
		return commodities;
	}
}