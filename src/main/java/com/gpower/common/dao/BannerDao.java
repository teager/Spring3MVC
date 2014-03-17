/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao;

import java.util.Map;

import com.gpower.common.entity.GpProperty;

public interface BannerDao {

	public GpProperty save(GpProperty gpProperty);
	
	public GpProperty updateProperty(GpProperty gpProperty);
	
	public void removeProperty(GpProperty gpProperty);
	
	public String getProperty(String name);
	
	public Map<String, String> getProperty();
}
