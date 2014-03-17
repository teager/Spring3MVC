package com.gpower.common.entity;

import java.io.Serializable;

import com.gpower.common.type.BannerType;

public class Banner implements Serializable {

	private static final long serialVersionUID = -1030523803338447626L;

	private Long id;

	private String productId;

	private String appStoreId;

	private String imageUrl;

	private BannerType bannerType;

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

	public BannerType getBannerType() {
		return bannerType;
	}

	public void setBannerType(BannerType bannerType) {
		this.bannerType = bannerType;
	}

}