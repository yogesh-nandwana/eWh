package com.na.ewh.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class GodownInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private AddressInfo addressInfo;
	
	@OneToOne
	private ContactInfo contactInfo;
	
	@OneToMany
	private Set<StackInfo> stacks;
	
	private Date openingDate;
	
	private String remarks;

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
}