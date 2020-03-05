package com.ryum.accountbook.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * HttpStatusException
 * 
 * @author ryum
 */
public class HttpStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private HttpStatus status;

	@Getter
	private String message;

	@Getter
	private String[] codes;

	public HttpStatusException(HttpStatus status, String message, String... codes) {
		super();
		this.status = status;
		this.message = message;
		this.codes = codes;
	}

	public HttpStatusException(HttpStatus status, Throwable cause) {
		super(cause);
		this.status = status;
	}

}
