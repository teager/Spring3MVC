package com.gpower.common.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthException extends RuntimeException {

	private static final long serialVersionUID = 5880689669433149789L;

	public NotAuthException(String session) {
		super("not validition session: " + session );
	}

}
