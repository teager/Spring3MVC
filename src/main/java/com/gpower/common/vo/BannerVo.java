package com.gpower.common.vo;

import java.io.Serializable;

import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Banner;

public class BannerVo implements Serializable{

	private static final long serialVersionUID = 987975313303903964L;

	private String productId;

	private String appStoreId;

	private String imageUrl;
	
	private String downloadURL;

	public BannerVo() {
		super();
	}

	public BannerVo(Banner banner, Anonymity anonymity) {
		this.productId = banner.getProductId();
		this.appStoreId = banner.getAppStoreId();
		this.imageUrl = banner.getImageUrl();
		this.downloadURL = banner.getDownloadURL();
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

}
