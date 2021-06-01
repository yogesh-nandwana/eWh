package com.na.ewh.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ContactInfo {
	@Id
	private Long id;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	private CustomerInfo customer;

	@Email
	private String email;

	@NotNull
	private String phoneNos;

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNo(String mobileNo) {
		this.phoneNos = mobileNo;
	}

	@Override
	public String toString() {
		return Stream.of(email,phoneNos).filter(str->str!=null && !str.isEmpty()).collect(Collectors.joining(","));
	}
}