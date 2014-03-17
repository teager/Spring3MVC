/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao.page;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;


public class PageFilter implements Serializable {

	private static final long serialVersionUID = -1034038201243412832L;

	private Map<String, String> filters = new HashMap<String, String>();

	void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

	public void add(String name, String value) {
		filters.put(name, value);
	}

	public Boolean has(String name) {
		return filters.containsKey(name);
	}

	public Boolean isEmpty() {
		return filters.isEmpty();
	}

	public String getString(String name) {
		if (filters.containsKey(name)) {
			return filters.get(name);
		}
		return null;
	}

	public Integer getInteger(String name) {
		if (filters.containsKey(name) && NumberUtils.isNumber(filters.get(name))) {
			return NumberUtils.toInt(filters.get(name));
		}
		return null;
	}

	public Long getLong(String name) {
		if (filters.containsKey(name) && NumberUtils.isNumber(filters.get(name))) {
			return NumberUtils.toLong(filters.get(name));
		}
		return null;
	}

	public Double getDouble(String name) {
		if (filters.containsKey(name) && NumberUtils.isNumber(filters.get(name))) {
			return NumberUtils.toDouble(filters.get(name));
		}
		return null;
	}

	public void parser(String expressions) {
		List<String> subexpressions = Arrays.asList(expressions.split(";"));
		for (String node : subexpressions) {
			String[] array = node.split("==");
			filters.put(array[0], array[1]);
		}

		if (has("latitude") && has("longitude")) {
			Double distance = getDouble("distance") != null ? getDouble("distance") : 25.0;
			if (distance > 3080) {
				distance = 3080.00;
			}
		}
	}
}
