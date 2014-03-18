package com.gpower.common.type;

import org.codehaus.jackson.annotate.JsonValue;

public enum UpdateType {
	FORCE(0),

	SUGGEST(1),

	NO_NEED(2);

	private final Integer value;

	private UpdateType(Integer value) {
		this.value = value;
	}

	@JsonValue
	public Integer value() {
		return value;
	}
}
