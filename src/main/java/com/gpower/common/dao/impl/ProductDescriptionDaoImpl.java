package com.gpower.common.dao.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gpower.common.dao.ProductDescriptionDao;
import com.gpower.common.entity.ProductDescription;

public class ProductDescriptionDaoImpl implements ProductDescriptionDao {

	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(ProductDescriptionDaoImpl.class);

	private static final String LOAD_DESCRIPTION = "SELECT name, description FROM product_description";
	private static final String INSERT_DESCRIPTION = "INSERT INTO product_description(name, description) VALUES(?,?)";
	private static final String UPDATE_DESCRIPTION = "UPDATE product_description SET description=? WHERE name=?";
	private static final String DELETE_DESCRIPTION = "DELETE FROM product_description WHERE name LIKE ?";

	private static Map<String, String> descriptions = new ConcurrentHashMap<String, String>();

	private static Calendar initTime = Calendar.getInstance();

	public ProductDescription save(ProductDescription gpProductDescription) {
		jdbcTemplate.update(INSERT_DESCRIPTION,
				new Object[] { gpProductDescription.getName(), gpProductDescription.getDescription() });
		descriptions.put(gpProductDescription.getName(), gpProductDescription.getDescription());
		return gpProductDescription;
	}

	private Map<String, String> init() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(LOAD_DESCRIPTION);
		for (Map<String, Object> row : rows) {
			String name = (String) row.get("name");
			String description = (String) row.get("description");
			descriptions.put(name, description);
		}
		initTime = Calendar.getInstance();
		return descriptions;
	}

	public ProductDescription updateProductDescription(ProductDescription gpProductDescription) {
		jdbcTemplate.update(UPDATE_DESCRIPTION,
				new Object[] { gpProductDescription.getName(), gpProductDescription.getDescription() });
		descriptions.put(gpProductDescription.getName(), gpProductDescription.getDescription());
		return gpProductDescription;
	}

	public void removeProductDescription(ProductDescription gpProductDescription) {
		jdbcTemplate.update(DELETE_DESCRIPTION, new Object[] { gpProductDescription.getName() });
		descriptions.remove(gpProductDescription.getName());
	}

	public String getProductDescription(String name) {
		Calendar currentTime = Calendar.getInstance();
		if (descriptions.isEmpty() || currentTime.getTimeInMillis() - initTime.getTimeInMillis() > 1000 * 60 * 5) {
			init();
			logger.info("init descriptions...");
		}
		return descriptions.get(name);
	}

	public Map<String, String> getProductDescription() {
		Calendar currentTime = Calendar.getInstance();
		if (descriptions.isEmpty() || currentTime.getTimeInMillis() - initTime.getTimeInMillis() > 1000 * 60 * 5) {
			init();
			logger.info("init descriptions...");
		}
		return descriptions;
	}

	public Map<String, String> getDescriptions() {
		return descriptions;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
