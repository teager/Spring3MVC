package com.gpower.common.dto;

import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.gpower.common.dto.parent.TransferObject;
import com.gpower.common.entity.Anonymity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnonymityDto extends TransferObject<Anonymity> {

	private static final long serialVersionUID = -4619912368860710658L;

	private String clientDeviceId;

	private String clientDeviceName;

	private String clientDeviceToken;

	private String loginIp;

	private String clientOS;

	private String clientLang;

	private String productID;

	private String productVersion;

	private Calendar productlListUpdateTime;

	private Calendar bannerUpdateTime;

	public AnonymityDto() {

	}

	public String getClientDeviceId() {
		return clientDeviceId;
	}

	public void setClientDeviceId(String clientDeviceId) {
		this.clientDeviceId = clientDeviceId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getClientOS() {
		return clientOS;
	}

	public void setClientOS(String clientOS) {
		this.clientOS = clientOS;
	}

	public String getClientDeviceName() {
		return clientDeviceName;
	}

	public void setClientDeviceName(String clientDeviceName) {
		this.clientDeviceName = clientDeviceName;
	}

	public String getClientDeviceToken() {
		return clientDeviceToken;
	}

	public void setClientDeviceToken(String clientDeviceToken) {
		this.clientDeviceToken = clientDeviceToken;
	}

	public String getClientLang() {
		return clientLang;
	}

	public void setClientLang(String clientLang) {
		this.clientLang = clientLang;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public Calendar getProductlListUpdateTime() {
		return productlListUpdateTime;
	}

	public void setProductlListUpdateTime(Calendar productlListUpdateTime) {
		this.productlListUpdateTime = productlListUpdateTime;
	}

	public Calendar getBannerUpdateTime() {
		return bannerUpdateTime;
	}

	public void setBannerUpdateTime(Calendar bannerUpdateTime) {
		this.bannerUpdateTime = bannerUpdateTime;
	}

	@Override
	public Anonymity toObject(Anonymity anonymity) {
		if (clientDeviceId != null) {
			anonymity.setClientDeviceId(clientDeviceId);
		}
		if (clientDeviceName != null) {
			anonymity.setClientDeviceName(clientDeviceName);
		}
		if (clientDeviceToken != null) {
			anonymity.setClientDeviceToken(clientDeviceToken);
		}
		if (clientOS != null) {
			anonymity.setClientOS(clientOS);
		}
		if (clientLang != null) {
			anonymity.setClientLang(clientLang);
		}
		if (productID != null) {
			anonymity.setProductID(productID);
		}
		if (productVersion != null) {
			anonymity.setProductVersion(productVersion);
		}

		return anonymity;
	}

}
