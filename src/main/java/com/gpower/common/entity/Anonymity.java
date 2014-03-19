package com.gpower.common.entity;

import java.io.Serializable;
import java.util.Calendar;

import com.gpower.common.type.FreeType;

public class Anonymity implements Serializable {

	private static final long serialVersionUID = 5997398030652622065L;

	private Long id;
	
	private String clientDeviceId;

	private String clientDeviceName;

	private String clientDeviceToken;

	private String loginIp;

	private String clientOS;
	
	private String clientLang;
	
	private String productID;
	
	private String productVersion;
	
	private FreeType freeType;

	private Calendar createTime;

	private Calendar updateTime;

	private Calendar uninstallTime;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientDeviceId() {
		return clientDeviceId;
	}

	public void setClientDeviceId(String clientDeviceId) {
		this.clientDeviceId = clientDeviceId;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
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

	public Calendar getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}

	public Calendar getUninstallTime() {
		return uninstallTime;
	}

	public void setUninstallTime(Calendar uninstallTime) {
		this.uninstallTime = uninstallTime;
	}

	public FreeType getFreeType() {
		return freeType;
	}

	public void setFreeType(FreeType freeType) {
		this.freeType = freeType;
	}

}
