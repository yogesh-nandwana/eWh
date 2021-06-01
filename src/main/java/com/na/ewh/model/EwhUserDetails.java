package com.na.ewh.model;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class EwhUserDetails implements UserDetails {
	private static final long serialVersionUID = 1209089591019686291L;

	private String userName;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;

	public EwhUserDetails(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.enabled = user.isEnabled();
		this.authorities = Arrays.stream(user.getRoles().split(","))
								 .map(SimpleGrantedAuthority::new)
								 .collect(Collectors.toList());
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
}