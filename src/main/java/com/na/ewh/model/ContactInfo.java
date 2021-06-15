package com.na.ewh.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "contactInfo",fetch = FetchType.LAZY)
	private CustomerInfo customer;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String phoneNos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CustomerInfo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNos() {
		return phoneNos;
	}
	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}

	@Override
	public String toString() {
		return Stream.of(email,phoneNos).filter(str->str!=null && !str.isEmpty()).collect(Collectors.joining(","));
	}
}