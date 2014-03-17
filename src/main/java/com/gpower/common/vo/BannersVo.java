package com.gpower.common.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Banner;

public class BannersVo implements Serializable {

	private static final long serialVersionUID = 1444741726787055989L;

	private Long count;

	private Long fsProductId;

	private Long fsAppStoreId;

	private Long fsImageUrl;

	private List<BannerVo> banners;

	public BannersVo() {

	}

	public BannersVo(List<Banner> banners, Anonymity anonymity) {
		for (Banner banner : banners) {
			this.addBanner(new BannerVo(banner, anonymity));
		}
		this.setCount(new Long(banners.size()));
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

	public Long getFsProductId() {
		return fsProductId;
	}

	public void setFsProductId(Long fsProductId) {
		this.fsProductId = fsProductId;
	}

	public Long getFsAppStoreId() {
		return fsAppStoreId;
	}

	public void setFsAppStoreId(Long fsAppStoreId) {
		this.fsAppStoreId = fsAppStoreId;
	}

	public Long getFsImageUrl() {
		return fsImageUrl;
	}

	public void setFsImageUrl(Long fsImageUrl) {
		this.fsImageUrl = fsImageUrl;
	}

	public List<BannerVo> getBanners() {
		return banners;
	}

	public void setBanners(List<BannerVo> banners) {
		this.banners = banners;
	}

}
