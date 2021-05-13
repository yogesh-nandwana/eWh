package com.na.ewh.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

@Entity
public class Contact {
	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Customer customer;

	@Email
	private String email;

	private String landlineNo;

	private String mobileNo;

	@Override
	public String toString() {
		return Stream.of(email,landlineNo,mobileNo).filter(str->str!=null && !str.isEmpty()).collect(Collectors.joining(","));
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}