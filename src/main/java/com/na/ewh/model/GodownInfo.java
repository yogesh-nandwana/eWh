package com.na.ewh.model;

import java.util.Set;

import javax.persistence.*;

public class GodownInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private AddressInfo address;
	
	@OneToOne
	private ContactInfo contact;
	
	@OneToMany
	private Set<StackInfo> stacks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressInfo getAddress() {
		return address;
	}

	public void setAddress(AddressInfo address) {
		this.address = address;
	}

	public ContactInfo getContact() {
		return contact;
	}

	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}

	public Set<StackInfo> getStacks() {
		return stacks;
	}

	public void setStacks(Set<StackInfo> stacks) {
		this.stacks = stacks;
	}
}