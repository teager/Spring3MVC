package com.gpower.common.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.gpower.common.dto.AnonymityDto;
import com.gpower.common.entity.Anonymity;
import com.gpower.common.type.BooleanType;
import com.gpower.common.type.UpdateType;
import com.gpower.common.utils.SessionUtils;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SessionVo implements Serializable{

	private static final long serialVersionUID = -1452056432994782593L;

	private String session;

	private BooleanType fullScreenAd = BooleanType.FALSE;

	private BooleanType duringFree = BooleanType.FALSE;

	private BooleanType bannerUpdate = BooleanType.FALSE;

	private BooleanType productListUpdate = BooleanType.FALSE;

	private UpdateType updateType;

	private Calendar serverTime;

	public SessionVo() {

	}

	public SessionVo(Map<String, String> properties, Anonymity anonymity, AnonymityDto dto) {
		String propValue = properties.get("fullScreenAd");
		if (propValue != null && propValue.equals("true")) {
			this.fullScreenAd = BooleanType.TRUE;
		}
		propValue = properties.get(anonymity.getProductID() + ".duringFree");
		if (propValue != null && propValue.equals("true")) {
			this.duringFree = BooleanType.TRUE;
		}

		this.session = SessionUtils.createAnonymitySessionToken(anonymity);

		propValue = properties.get("bannerUpdateTime");
		if (propValue != null) {
			try {
				Calendar bannerUpdateTime = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				bannerUpdateTime.setTime(sdf.parse(propValue));
				if (dto.getBannerUpdateTime().getTimeInMillis() < bannerUpdateTime.getTimeInMillis()) {
					this.bannerUpdate = BooleanType.TRUE;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		propValue = properties.get("productListUpdateTime");
		if (propValue != null) {
			try {
				Calendar bannerUpdateTime = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				bannerUpdateTime.setTime(sdf.parse(propValue));
				if (dto.getBannerUpdateTime().getTimeInMillis() < bannerUpdateTime.getTimeInMillis()) {
					this.productListUpdate = BooleanType.TRUE;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (StringUtils.isNotBlank(dto.getProductVersion())) {
			String productVersion = dto.getProductVersion();
			if (properties.get(dto.getProductID() + "_lowestVersion") != null
					&& properties.get(dto.getProductID() + "_latestVersion") != null) {
				if (productVersion.compareTo(properties.get(dto.getProductID() + "_lowestVersion")) < 0) {
					this.updateType = UpdateType.FORCE;
				} else if (productVersion.compareTo(properties.get(dto.getProductID() + "_latestVersion")) < 0) {
					this.updateType = UpdateType.SUGGEST;
				} else {
					this.updateType = UpdateType.NO_NEED;
				}
			} else {
				this.updateType = UpdateType.NO_NEED;
			}

		}

		this.serverTime = Calendar.getInstance();
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public BooleanType getFullScreenAd() {
		return fullScreenAd;
	}

	public void setFullScreenAd(BooleanType fullScreenAd) {
		this.fullScreenAd = fullScreenAd;
	}

	public BooleanType getDuringFree() {
		return duringFree;
	}

	public void setDuringFree(BooleanType duringFree) {
		this.duringFree = duringFree;
	}

	public BooleanType getBannerUpdate() {
		return bannerUpdate;
	}

	public void setBannerUpdate(BooleanType bannerUpdate) {
		this.bannerUpdate = bannerUpdate;
	}

	public BooleanType getProductListUpdate() {
		return productListUpdate;
	}

	public void setProductListUpdate(BooleanType productListUpdate) {
		this.productListUpdate = productListUpdate;
	}

	public UpdateType getUpdateType() {
		return updateType;
	}

	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	public Calendar getServerTime() {
		return serverTime;
	}

	public void setServerTime(Calendar serverTime) {
		this.serverTime = serverTime;
	}
}
