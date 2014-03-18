package com.gpower.common.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gpower.common.dao.ProductDao;
import com.gpower.common.dao.page.Page;
import com.gpower.common.entity.Product;
import com.gpower.common.type.BooleanType;

public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_PRODUCT = "INSERT INTO product(productId, productName, appIsnew, appStoreId, schema, description, productPrice, status) VALUES(?,?,?,?,?,?,?,?)";
	private static final String UPDATE_PRODUCT = "UPDATE product SET status=? WHERE id=?";

	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	protected class ProductMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setProductId(rs.getString("productId"));
			product.setProductName(rs.getString("productName"));
			product.setAppIsnew(BooleanType.valueOf(rs.getString("appIsnew")));
			product.setAppStoreId(rs.getString("appStoreId"));
			product.setSchema(rs.getString("schema"));
			product.setDescription(rs.getString("description"));
			product.setProductPrice(rs.getDouble("productPrice"));
			product.setStatus(BooleanType.valueOf(rs.getString("status")));
			return product;
		}
	}

	public Product save(Product product) {
		logger.info("insert a new product!");
		jdbcTemplate.update(
				INSERT_PRODUCT,
				new Object[] { product.getProductId(), product.getProductName(), product.getAppIsnew(),
						product.getAppStoreId(), product.getSchema(), product.getDescription(),
						product.getProductPrice(), product.getStatus() });
		return product;
	}

	public Product updateProduct(Product product) {
		jdbcTemplate.update(UPDATE_PRODUCT, new Object[] { product.getStatus(), product.getId() });
		return product;
	}

	public List<Product> getProduct(Page<Product> page) {
		String querySql = "SELECT * FROM product b WHERE true";
		if (page.getPageFilter().has("status")) {
			querySql += " and b.status = " + page.getPageFilter().getString("status");
		}

		if ("id".equals(page.getPageOrder().getName())) {
			querySql += " order by a.id desc";
		} else if ("updateTime".equals(page.getPageOrder().getName())) {
			querySql += " order by u.updateTime desc";
		}

		List<Product> result = jdbcTemplate.query(querySql + " limit ?, ?", new Object[] { page.getStartPosition(),
				page.getPageSize() }, new ProductMapper());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
