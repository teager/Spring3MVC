/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao;

import java.util.Map;

import com.gpower.common.entity.ProductDescription;

public interface ProductDescriptionDao {

	public ProductDescription save(ProductDescription gpProductDescription);
	
	public ProductDescription updateProductDescription(ProductDescription gpProductDescription);
	
	public void removeProductDescription(ProductDescription gpProductDescription);
	
	public String getProductDescription(String name);
	
	public Map<String, String> getProductDescription();
}
