package com.na.ewh.model;

import javax.persistence.*;

@Entity
public class CommodityInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String type;
	private Float unitPrice;
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