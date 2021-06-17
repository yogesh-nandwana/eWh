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
	
	@Valid @NotBlank
	private String address;
	
	@Valid @NotBlank
	private String contactNo;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getNoOfStacks() {
		return noOfStacks;
	}

	public void setNoOfStacks(Integer noOfStacks) {
		this.noOfStacks = noOfStacks;
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

	public Set<StackInfo> getStacks() {
		return stacks;
	}

	public void setStacks(Set<StackInfo> stacks) {
		this.stacks = stacks;
	}
}