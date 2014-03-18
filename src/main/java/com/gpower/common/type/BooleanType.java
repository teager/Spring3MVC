package com.gpower.common.type;

import org.codehaus.jackson.annotate.JsonValue;

public enum BooleanType {
	FALSE(0),

	TRUE(1);

	private final Integer value;

	private BooleanType(Integer value) {
		this.value = value;
	}

	@JsonValue
	public Integer value() {
		return value;
	}

	public static BooleanType fromInt(Integer value) {
		for (BooleanType type : BooleanType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
	}
}
