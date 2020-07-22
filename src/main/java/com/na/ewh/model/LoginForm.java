package com.na.ewh.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginForm {
	@NotNull(message = "UserId is required!")
	@Size(min = 4,max=10,message = "UserId should be between 4 to 10 chars!")
	private final String userId;
	
	@NotNull(message = "Password is required!")
	@Size(min = 6,max=10,message = "Password should be between 6 to 10 chars!")
	private final String pwd;
}