package com.gpower.common.type;

import org.codehaus.jackson.annotate.JsonValue;

public enum BannerType {
	NOMALE(0),

	FULLSCREEN(1);

	private final Integer value;

	private BannerType(Integer value) {
		this.value = value;
	}

	@JsonValue
	public Integer value() {
		return value;
	}
}
