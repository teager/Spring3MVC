/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.gpower.common.dao.page;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class PageOrder implements Serializable {

	private static final long serialVersionUID = -6128934348339502848L;

	private String name;

	private boolean asc;

	public boolean isEmpty() {
		return StringUtils.isBlank(name);
	}

	public String getName() {
		return name;
	}

	public boolean isAsc() {
		return asc;
	}

	public void parser(String expressions) {
		String[] array = expressions.split("==");
		this.name = array[0];

		if (StringUtils.equalsIgnoreCase("asc", array[1])) {
			this.asc = true;
		} else {
			this.asc = false;
		}
	}
}
