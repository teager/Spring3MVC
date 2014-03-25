package com.gpower.common.vo;

import java.io.Serializable;
import java.util.Map;

import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Product;
import com.gpower.common.type.BooleanType;

public class ProductVo implements Serializable {

	private static final long serialVersionUID = 987975313303903964L;

	private String productId;

	private String productName;

	private BooleanType appIsnew;

	private String appStoreId;	
	
	private String appIcon;
	
	private String downloadURL;
	
	private String schema;

	private String productPrice;

	private String description;

	public ProductVo() {
		super();
	}

	public ProductVo(Product product, Anonymity anonymity, Map<String, String> descriptions) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.appStoreId = product.getAppStoreId();
		this.appIcon = product.getAppIcon();
		this.downloadURL = product.getDownloadURL();
		
		this.appIsnew = product.getAppIsnew();
		this.schema = product.getSchema();
		this.productPrice = product.getProductPrice();
		String description = descriptions.get(anonymity.getProductID() + "_" + anonymity.getClientLang());
		if (description != null) {
			this.description = description;
		} else {
			this.description = descriptions.get(product.getProductId() + "_en_US");
		}
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

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
