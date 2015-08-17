package com.tupa.app.exception.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tupa.app.error.model.ErrorDetail;
import com.tupa.app.exception.SampleException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(SampleException.class)
	public ResponseEntity<?> handleNotFound(SampleException rnfe, HttpServletRequest request){
		System.out.println("execpetionnn /////////////////////////////////////");
		
		ErrorDetail errorDetail = new ErrorDetail();
		// Populate errorDetail instance
		errorDetail.setTimeStamp(new Date().getTime());
		errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDetail.setDeveloperMessage("Path Not Found");
		String requestPath = (String) request.getAttribute("javax.servlet.error.request_uri");
		if(requestPath == null) {
		requestPath = request.getRequestURI();
		}
		
		
		return new ResponseEntity<>(errorDetail, null, HttpStatus. BAD_REQUEST);
		
	}
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		System.out.println("111111111111111111111111111111111111111111111111111111111111");
		return super.handleServletRequestBindingException(ex, headers, status, request);
	}
	
}
