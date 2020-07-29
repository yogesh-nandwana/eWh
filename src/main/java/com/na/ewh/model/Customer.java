package com.na.ewh.model;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 5,max = 15,message = "First Name must be between 5 to 15 characters long.")
	private String firstName;
	
	private String middleName;
	
	@NotNull
	@Size(min = 5,max = 15,message = "Last Name must be between 5 to 15 characters long.")
	private String lastName;
	
	@NotNull
	private Date dob;

	private Date dor;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TYPE type;

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
	
	private String remark;

	private static enum TYPE {
		TRADER("Trader"),FARMER("Farmer");
		private String type;
		TYPE(String custType) {
			this.type = custType;
		}
		@Override
		public String toString() {
			return type;
		}
	};
	
	public String getAddress() {
		return Stream.of(houseNo,street,landmark,city,state,country,pincode).filter(str -> str!=null && !str.isEmpty()).collect(Collectors.joining(","));
	}
	
	public String getName() {
		return Stream.of(firstName,middleName,lastName).filter(str -> str!=null && !str.isEmpty()).collect(Collectors.joining(" "));
	}
}
