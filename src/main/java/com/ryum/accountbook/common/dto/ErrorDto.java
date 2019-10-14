package com.ryum.accountbook.common.dto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import com.ryum.accountbook.common.exception.HttpStatusException;

import lombok.Getter;
import lombok.Setter;

/**
 * 에러 DTO
 * @author ryum
 */
@Getter @Setter
public class ErrorDto {

	private String path;
	private String error;
	private int status;
	private String message;
	
	public ErrorDto(HttpServletRequest req, HttpStatusException exception) {
		this.path = req.getRequestURI();
		this.error = exception.getStatus().name();
		this.status = exception.getStatus().value();
		this.message = exception.getMessage();
	}
	
	public ErrorDto(HttpServletRequest req, Exception exception) {
		this(req, new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception));
	}
}
