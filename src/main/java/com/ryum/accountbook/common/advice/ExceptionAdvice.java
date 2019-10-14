package com.ryum.accountbook.common.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ryum.accountbook.common.dto.ErrorDto;
import com.ryum.accountbook.common.exception.HttpStatusException;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionAdvice {

	@ExceptionHandler(HttpStatusException.class)
	public ResponseEntity<?> httpStatusException(HttpServletRequest req, HttpStatusException exception) {
		return ResponseEntity.status(exception.getStatus()).body(new ErrorDto(req, exception));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> internalServerError(HttpServletRequest req, Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(req, exception));
	}
}
