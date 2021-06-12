package com.na.ewh.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class CommodityInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 4,max = 8,message = "First Name must be between 4 to 8 characters long.")
	private String name;
	private String type;

	@Min(value = 1)
	private Float unitPrice;

	@Min(value = 1)
	private Float storageCharge;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Float getStorageCharge() {
		return storageCharge;
	}
	public void setStorageCharge(Float storageCharge) {
		this.storageCharge = storageCharge;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommodityInfo [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", storageCharge=");
		builder.append(storageCharge);
		builder.append("]");
		return builder.toString();
	}
}