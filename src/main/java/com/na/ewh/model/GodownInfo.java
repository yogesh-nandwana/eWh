package com.na.ewh.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
public class GodownInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid @OneToOne
	private AddressInfo addressInfo;
	
	@Valid @OneToOne
	private ContactInfo contactInfo;
	
	@Valid
	@Max(value = 50)
	@Min(value = 10)
	private Integer noOfStacks;
	
	private Date openingDate;
	
	private String remarks;
	
	@OneToMany
	private Set<StackInfo> stacks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Set<StackInfo> getStacks() {
		return stacks;
	}

	public void setStacks(Set<StackInfo> stacks) {
		this.stacks = stacks;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getNoOfStacks() {
		return noOfStacks;
	}

	public void setNoOfStacks(Integer noOfStacks) {
		this.noOfStacks = noOfStacks;
	}
}