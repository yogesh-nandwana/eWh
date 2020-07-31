package com.na.ewh.model;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@Enumerated(EnumType.STRING)
	private INITIAL initial;

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

	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
	private Contact contact;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
	private Address address;
	
	private String remark;
	
	public static enum INITIAL{
		MR("Mr"),MRS("Mrs"),MISS("Miss");
		private String initial;
		private INITIAL(String initial) {
			this.initial = initial;
		}
		@Override
		public String toString(){
			return this.initial;
		}
	}

	public static enum TYPE {
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
	
	public String getName() {
		return Stream.of(initial.toString(),firstName,middleName,lastName).filter(str -> str!=null && !str.isEmpty()).collect(Collectors.joining(" "));
	}
}