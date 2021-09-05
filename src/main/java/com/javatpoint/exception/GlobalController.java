package com.javatpoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalController {

	@ExceptionHandler(BookNameNotFoundException.class)
	public ResponseEntity<?> HandleBookNotFound(BookNameNotFoundException exception, WebRequest request)
	{
	  errorDetail Errordetail =new errorDetail("No Book is Available");
	  return new ResponseEntity(Errordetail, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<?> HandleBookNotFound(BookNotFound exception, WebRequest request)
	{
	  errorDetail Errordetail =new errorDetail("No id is Available");
	  return new ResponseEntity(Errordetail, HttpStatus.NOT_FOUND);
	}

	
}
