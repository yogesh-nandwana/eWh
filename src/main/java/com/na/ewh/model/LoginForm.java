package com.na.ewh.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
	@NotNull(message = "UserId is required!")
	@Size(min = 4,max=10,message = "UserId should be between 4 to 10 chars!")
	private String userId = null;
	
	@NotNull(message = "Password is required!")
	@Size(min = 6,max=10,message = "Password should be between 6 to 10 chars!")
	private String pwd = null;

	public String getUserId() {
		return userId;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}