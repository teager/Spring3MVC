package com.gpower.common.entity;

import java.io.Serializable;

import com.gpower.common.type.BooleanType;

public class Product implements Serializable {

	private static final long serialVersionUID = -5929623065305344552L;

	private Long id;

	private String productId;

	private String productName;

	private BooleanType appIsnew;

	private String appStoreId;

	private String schema;

	private Double productPrice;

	private String description;
	
	private BooleanType status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BooleanType getAppIsnew() {
		return appIsnew;
	}

	public void setAppIsnew(BooleanType appIsnew) {
		this.appIsnew = appIsnew;
	}

	public String getAppStoreId() {
		return appStoreId;
	}

	public void setAppStoreId(String appStoreId) {
		this.appStoreId = appStoreId;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BooleanType getStatus() {
		return status;
	}

	public void setStatus(BooleanType status) {
		this.status = status;
	}
}