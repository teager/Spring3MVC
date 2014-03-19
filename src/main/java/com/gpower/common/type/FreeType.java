package com.gpower.common.type;

import org.codehaus.jackson.annotate.JsonValue;

public enum FreeType {
	EVER(0),

	PERIOD_FREE(1),

	PAYMENT(2);

	private final Integer value;

	private FreeType(Integer value) {
		this.value = value;
	}

	@JsonValue
	public Integer value() {
		return value;
	}
	
	public static FreeType fromInt(Integer value) {
		for (FreeType type : FreeType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
	}
}
