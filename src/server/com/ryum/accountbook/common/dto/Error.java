package com.ryum.accountbook.common.dto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import com.ryum.accountbook.common.exception.HttpStatusException;

import lombok.Getter;
import lombok.Setter;

/**
 * 에러
 * @author ryum
 */
@Getter @Setter
public class Error {

	private String path;
	private String error;
	private int status;
	private String message;
	
	public Error(HttpServletRequest req, HttpStatusException exception) {
		this.path = req.getRequestURI();
		this.error = exception.getStatus().name();
		this.status = exception.getStatus().value();
		this.message = exception.getMessage();
	}
	
	public Error(HttpServletRequest req, Exception exception) {
		this(req, new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception));
	}
}
