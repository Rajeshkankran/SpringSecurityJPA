package com.tupa.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SampleException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public SampleException() {

	}
	
	public SampleException(String message) {
		
		super(message);
		
	}
	
	public SampleException(String message, Throwable cause) {
		super(message,cause);
	}
}
