package com.na.ewh.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.ewh.model.GodownInfo;
import com.na.ewh.repositroy.ICommodityRepository;
import com.na.ewh.repositroy.IGodownRepository;

@Service
public class GodownService {
	private static final Logger log = LoggerFactory.getLogger(GodownService.class);
	
	@Autowired
	IGodownRepository godwnRepository;
	
	public Iterable<GodownInfo> getGodowns() {
		log.info("Inside getGodowns()");
		return godwnRepository.findAll();
	}
	
	public void saveGodown(GodownInfo godownInfo) {
		log.info("Inside saveGodown()");
		godwnRepository.save(godownInfo);
	}
}