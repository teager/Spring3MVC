package com.gpower.common.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gpower.common.entity.Anonymity;
import com.gpower.common.entity.Product;

public class ProductsVo implements Serializable {

	private static final long serialVersionUID = 1444741726787055989L;

	private Long count;

	private List<ProductVo> products;

	public ProductsVo() {

	}

	public ProductsVo(List<Product> products, Anonymity anonymity) {
		for (Product product : products) {
			this.addProduct(new ProductVo(product, anonymity));
		}
		this.setCount(new Long(products.size()));
	}

	private void addProduct(ProductVo productVo) {
		if (this.products == null) {
			this.products = new ArrayList<ProductVo>();
		}
		this.products.add(productVo);
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<ProductVo> getproducts() {
		return products;
	}

	public void setproducts(List<ProductVo> products) {
		this.products = products;
	}

}
