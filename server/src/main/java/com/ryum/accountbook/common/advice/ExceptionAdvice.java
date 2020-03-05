package com.ryum.accountbook.common.advice;

import com.ryum.accountbook.common.dto.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception Advice
 * 
 * @author ryum
 */
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionAdvice {

//	@ExceptionHandler(HttpStatusException.class)
//	public ResponseEntity<?> httpStatusException(HttpServletRequest req, HttpStatusException exception) {
//		return ResponseEntity.status(exception.getStatus()).body(new Response(exception.getMessage(), exception.getCodes()));
//	}

	@ExceptionHandler(value = { EmptyResultDataAccessException.class })
	public ResponseEntity<?> notFound(Exception e) {
		return Response.notFound().message(e.getMessage()).build();
	}

	@ExceptionHandler(value = { HttpMessageNotReadableException.class, DataIntegrityViolationException.class })
	public ResponseEntity<?> badRequest(Exception e) {
		return Response.badRequest().message(e.getMessage()).build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> internalServerError(Exception e) {
		return Response.internalServerError().message(e.getMessage()).build();
	}

}
