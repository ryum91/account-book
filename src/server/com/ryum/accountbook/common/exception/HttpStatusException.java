package com.ryum.accountbook.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * HttpStatusException
 * @author ryum
 */
public class HttpStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private HttpStatus status;
	
	public HttpStatusException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
	
	public HttpStatusException(HttpStatus status, Throwable cause) {
		super(cause);
		this.status = status;
	}
	
}
