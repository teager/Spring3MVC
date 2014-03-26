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

	private Long bannerCount;
	
	private Long fsBannerCount;
	
	private List<BannerVo> fsBanners;

	private List<BannerVo> banners;

	public BannersVo() {

	}

	public BannersVo(List<Banner> banners, Anonymity anonymity) {
		Long bannerCount = 0L;
		Long fsBannerCount = 0L;
		for (Banner banner : banners) {
			if (BannerType.FULLSCREEN.equals(banner.getBannerType())) {
				this.addFSBanner(new BannerVo(banner, anonymity));
				fsBannerCount++;
			} else {
				this.addBanner(new BannerVo(banner, anonymity));
				bannerCount++;
			}
		}
		this.bannerCount = bannerCount;
		this.fsBannerCount = fsBannerCount;
	}

	private void addFSBanner(BannerVo bannerVo) {
		if (this.fsBanners == null) {
			this.fsBanners = new ArrayList<BannerVo>();
		}
		this.fsBanners.add(bannerVo);
	}
	
	private void addBanner(BannerVo bannerVo) {
		if (this.banners == null) {
			this.banners = new ArrayList<BannerVo>();
		}
		this.banners.add(bannerVo);
	}

	public Long getBannerCount() {
		return bannerCount;
	}

	public void setBannerCount(Long bannerCount) {
		this.bannerCount = bannerCount;
	}

	public Long getFsBannerCount() {
		return fsBannerCount;
	}

	public void setFsBannerCount(Long fsBannerCount) {
		this.fsBannerCount = fsBannerCount;
	}

	public List<BannerVo> getFsBanners() {
		return fsBanners;
	}

	public void setFsBanners(List<BannerVo> fsBanners) {
		this.fsBanners = fsBanners;
	}

	public List<BannerVo> getBanners() {
		return banners;
	}

	public void setBanners(List<BannerVo> banners) {
		this.banners = banners;
	}

}
