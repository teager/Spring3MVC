/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao;

import java.util.List;

import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Product;

public interface ProductDao {

	public Product save(Product banner);
	
	public Product updateProduct(Product banner);
	
	public List<Product> getProduct(Page<Product> page);
}
