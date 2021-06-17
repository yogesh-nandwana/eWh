package com.na.ewh.model;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/** This class is used by Spring Security for login feature **/
public class EwhUserDetails extends User {
	private static final long serialVersionUID = 1209089591019686291L;

	public EwhUserDetails(UserInfo userInfo) {
		super(userInfo.getUserName(),userInfo.getPassword(),
				true,true,true,true,
				Arrays.stream(userInfo.getRoles().split(","))
				 .map(SimpleGrantedAuthority::new)
				 .collect(Collectors.toList()));
	}
}