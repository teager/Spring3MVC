package com.gpower.common.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Banner;
import com.gpower.common.type.BannerType;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BannersVo implements Serializable {

	private static final long serialVersionUID = 1444741726787055989L;

	private Long count;

	private String fsProductId;

	private String fsAppStoreId;

	private String fsImageUrl;

	private List<BannerVo> banners;

	public BannersVo() {

	}

	public BannersVo(List<Banner> banners, Anonymity anonymity) {
		Long bannerCount = 0L;
		for (Banner banner : banners) {
			if (BannerType.FULLSCREEN.equals(banner.getBannerType())) {
				this.fsProductId = banner.getProductId();
				this.fsAppStoreId = banner.getAppStoreId();
				this.fsImageUrl = banner.getImageUrl();
			} else {
				this.addBanner(new BannerVo(banner, anonymity));
				bannerCount++;
			}
		}
		this.setCount(bannerCount);
	}

	private void addBanner(BannerVo bannerVo) {
		if (this.banners == null) {
			this.banners = new ArrayList<BannerVo>();
		}
		this.banners.add(bannerVo);
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getFsProductId() {
		return fsProductId;
	}

	public void setFsProductId(String fsProductId) {
		this.fsProductId = fsProductId;
	}

	public String getFsAppStoreId() {
		return fsAppStoreId;
	}

	public void setFsAppStoreId(String fsAppStoreId) {
		this.fsAppStoreId = fsAppStoreId;
	}

	public String getFsImageUrl() {
		return fsImageUrl;
	}

	public void setFsImageUrl(String fsImageUrl) {
		this.fsImageUrl = fsImageUrl;
	}

	public List<BannerVo> getBanners() {
		return banners;
	}

	public void setBanners(List<BannerVo> banners) {
		this.banners = banners;
	}

}
