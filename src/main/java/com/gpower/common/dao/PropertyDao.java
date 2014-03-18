/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao;

import java.util.Map;

import com.gpower.common.entity.Property;

public interface PropertyDao {

	public Property save(Property gpProperty);
	
	public Property updateProperty(Property gpProperty);
	
	public void removeProperty(Property gpProperty);
	
	public String getProperty(String name);
	
	public Map<String, String> getProperty();
}
