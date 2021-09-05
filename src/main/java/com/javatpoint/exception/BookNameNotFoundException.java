package com.javatpoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="bookname not found")
public class BookNameNotFoundException extends RuntimeException {
	private static final long serialVersionUID=1L;

	public BookNameNotFoundException(String message) {
		super(message);
	}



}
