package com.na.ewh.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
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
}