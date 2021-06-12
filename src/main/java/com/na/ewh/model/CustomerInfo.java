package com.na.ewh.model;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
public class CustomerInfo {
	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	private String initial;

	@NotBlank
	@Size(min = 3,max = 10,message = "First Name must be between 3 to 10 characters long.")
	private String firstName;

	private String middleName;

	@NotBlank
	@Size(min = 5,max = 10,message = "Last Name must be between 3 to 10 characters long.")
	private String lastName;

	@NotNull
	private String customerType;

	@NotNull
	@Column(name="BIRTH_DATE")
	private Date dateOfBirth;

	@Column(name="REG_DATE")
	private Date registrationDate;

	@Valid @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	private ContactInfo contactInfo;

	@Valid @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	private AddressInfo addressInfo;
	
	private String remarks;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public AddressInfo getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getName() {
		return Stream.of(firstName,middleName,lastName).filter(str -> str!=null && !str.isEmpty()).collect(Collectors.joining(" "));
	}

	@Override
	public String toString() {
		return "Customer [initial=" + initial + ", firstName=" + firstName + ", middleName=" + middleName==null?"":middleName
				+ ", lastName=" + lastName + ", customerType=" + customerType + "]";
	}
}