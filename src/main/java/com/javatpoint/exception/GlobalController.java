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
	  ErrorDetail errordetail =new ErrorDetail("Book is not present in database");
	  return new ResponseEntity(errordetail, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotFound.class)
 	public ResponseEntity<?> HandleBookNotFound(BookNotFound exception, WebRequest request)
	{
	  ErrorDetail errordetail =new ErrorDetail("id is not present in database");
	  return new ResponseEntity(errordetail, HttpStatus.NOT_FOUND);
	}	
}
