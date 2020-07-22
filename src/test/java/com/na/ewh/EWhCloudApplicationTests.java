package com.na.ewh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.na.ewh.controllers.HomeController;
import com.na.ewh.controllers.LoginController;

@SpringBootTest
class EwhCloudApplicationTests {
	
	@Autowired
	HomeController homeController;
	
	@Autowired
	LoginController loginController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		assertThat(loginController).isNotNull();
	}
}