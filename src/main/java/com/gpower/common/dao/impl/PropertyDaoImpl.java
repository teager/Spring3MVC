package com.gpower.common.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gpower.common.dao.PropertyDao;
import com.gpower.common.entity.Property;

public class PropertyDaoImpl implements PropertyDao {

	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PropertyDaoImpl.class);

	private static final String LOAD_PROPERTIES = "SELECT name, propValue FROM gpProperty";
	private static final String INSERT_PROPERTY = "INSERT INTO gpProperty(name, propValue) VALUES(?,?)";
	private static final String UPDATE_PROPERTY = "UPDATE gpProperty SET propValue=? WHERE name=?";
	private static final String DELETE_PROPERTY = "DELETE FROM gp Property WHERE name LIKE ?";

	private Map<String, String> properties = new ConcurrentHashMap<String, String>();;

	public Property save(Property gpProperty) {
		jdbcTemplate.update(INSERT_PROPERTY, new Object[] { gpProperty.getName(), gpProperty.getPropValue() });
		properties.put(gpProperty.getName(), gpProperty.getPropValue());
		return gpProperty;
	}

	private Map<String, String> init() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(LOAD_PROPERTIES);
		for (Map<String, Object> row : rows) {
			String name = (String) row.get("name");
			String propValue = (String) row.get("propValue");
			properties.put(name, propValue);
		}
		return properties;
	}

	public Property updateProperty(Property gpProperty) {
		jdbcTemplate.update(UPDATE_PROPERTY, new Object[] { gpProperty.getName(), gpProperty.getPropValue() });
		properties.put(gpProperty.getName(), gpProperty.getPropValue());
		return gpProperty;
	}

	public void removeProperty(Property gpProperty) {
		jdbcTemplate.update(DELETE_PROPERTY, new Object[] { gpProperty.getName() });
		properties.remove(gpProperty.getName());
	}

	public String getProperty(String name) {
		if (properties.isEmpty()) {
			init();
			logger.info("init properties...");
		}
		return properties.get(name);
	}

	public Map<String, String> getProperty() {
		if (properties.isEmpty()) {
			init();
			logger.info("init properties...");
		}
		return properties;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
