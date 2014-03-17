package com.gpower.common.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5880689669433149789L;

	public NotFoundException(String type, String value) {
		super("not found a type: " + type + " value" + value);
	}

}
