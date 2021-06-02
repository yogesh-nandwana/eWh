package com.na.ewh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.na.ewh.controllers.HomeController;
import com.na.ewh.controllers.CustomerController;

@SpringBootTest()
class EWhCloudApplicationTests {
	
	@Autowired
	HomeController homeController;
	
	@Autowired
	CustomerController customerController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		assertThat(customerController).isNotNull();
	}
}