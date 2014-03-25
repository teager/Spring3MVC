package com.gpower.common.entity;

import java.io.Serializable;

import com.gpower.common.type.BannerType;
import com.gpower.common.type.BooleanType;

public class Banner implements Serializable {

	private static final long serialVersionUID = -1030523803338447626L;

	private Long id;

	private String productId;

	private String appStoreId;

	private String imageUrl;
	
	private String downloadURL;

	private BannerType bannerType;
	
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

	public String getAppStoreId() {
		return appStoreId;
	}

	public void setAppStoreId(String appStoreId) {
		this.appStoreId = appStoreId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public BannerType getBannerType() {
		return bannerType;
	}

	public void setBannerType(BannerType bannerType) {
		this.bannerType = bannerType;
	}

	public BooleanType getStatus() {
		return status;
	}

	public void setStatus(BooleanType status) {
		this.status = status;
	}
}