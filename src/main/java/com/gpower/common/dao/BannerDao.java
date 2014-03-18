/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao;

import java.util.List;

import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Banner;

public interface BannerDao {

	public Banner save(Banner banner);
	
	public Banner updateBanner(Banner banner);
	
	public List<Banner> getBanner(Page<Banner> page);
}
