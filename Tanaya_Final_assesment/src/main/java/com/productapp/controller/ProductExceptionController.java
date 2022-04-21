package com.productapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productapp.exceptions.ErrorDetails;
import com.productapp.exceptions.ProductNotFoundException;

@ControllerAdvice
@RestController
public class ProductExceptionController extends ResponseEntityExceptionHandler{


	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorDetails details=new ErrorDetails();
		details.setContact("infy.support@infy.com");
		details.setMessage(ex.getMessage());
		details.setDate(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
		
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(ProductNotFoundException ex, 
			WebRequest request){
		ErrorDetails details=new ErrorDetails();
		details.setContact("infy.support@infy.com");
		details.setMessage(ex.getMessage());
		details.setDate(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handle500(Exception ex, 
			WebRequest request){
		ErrorDetails details=new ErrorDetails();
		details.setContact("infy.support@infy.com");
		details.setMessage("internal server error");
		details.setDate(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}
}


