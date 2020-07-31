package com.na.ewh.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	private long id;
	
	private String houseNo;
	private String street;
	private String landmark;
	
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String country;
	@NotNull
	private String pincode;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	Customer customer;
	
	@Override
	public String toString() {
		return Stream.of(houseNo,street,landmark,city,state,country,pincode).filter(str -> str!=null && !str.isEmpty()).collect(Collectors.joining(","));
	}
}
