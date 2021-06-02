package com.na.ewh.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AddressInfo {
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
	CustomerInfo customer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public CustomerInfo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return Stream.of(houseNo,street,landmark,city,state,country,pincode).filter(str -> str!=null && !str.isEmpty()).collect(Collectors.joining(","));
	}
}