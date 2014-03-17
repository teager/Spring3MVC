package com.gpower.common.vo;

import java.io.Serializable;

import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Product;
import com.gpower.common.type.BooleanType;

public class ProductVo implements Serializable {

	private static final long serialVersionUID = 987975313303903964L;

	private String productId;

	private String productName;

	private BooleanType appIsnew;

	private String appStoreId;

	private String schema;

	private Double productPrice;

	private String description;

	public ProductVo() {
		super();
	}

	public ProductVo(Product product, Anonymity anonymity) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.appStoreId = product.getAppStoreId();

		this.appIsnew = product.getAppIsnew();
		this.schema = product.getSchema();
		this.productPrice = product.getProductPrice();
		this.description = product.getDescription();
		;

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAppStoreId() {
		return appStoreId;
	}

	public void setAppStoreId(String appStoreId) {
		this.appStoreId = appStoreId;
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

}
