package com.ryum.accountbook.common.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.BindingResult;

/**
 * 응답 객체
 * @author ryum
 */
public class Response {

  private BodyBuilder bodyBuilder;
  private Map<String, Object> body;
  
  public Response(HttpStatus status) {
    this.bodyBuilder = ResponseEntity.status(status);
    body = new HashMap<>();
    body.put("code", status.value());
  }
  
  public Response data(Object data) {
    body.put("data", data);
    return this;
  }
  
  public Response message(String message) {
    body.put("message", message);
    return this;
  }
  
  public Response errorCode(BindingResult result) {
    body.put("errorCode", result.getAllErrors().stream().map(e -> e.getDefaultMessage()).toArray(String[]::new));
    return this;
  }
  
  public ResponseEntity<?> build() {
    return bodyBuilder.body(body);
  }
  
  public static Response ok() {
    return new Response(HttpStatus.OK);
  }
  
  public static Response notFound() {
    return new Response(HttpStatus.NOT_FOUND);
  }
  
  public static Response badRequest() {
    return new Response(HttpStatus.BAD_REQUEST);
  }
  
  public static Response created() {
    return new Response(HttpStatus.CREATED);
  }
  
  public static Response internalServerError() {
    return new Response(HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
}
