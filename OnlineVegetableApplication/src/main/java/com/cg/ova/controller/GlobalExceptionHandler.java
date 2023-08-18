package com.cg.ova.controller;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ova.exception.CustomerNotFoundInCityException;
import com.cg.ova.exception.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {CustomerIdNotFoundException.class,BillIdNotFoundException.class,
	CartIdNotFoundException.class, FeedbackIdNotFoundException.class,
	OrderIdNotFoundException.class,UserNotFoundException.class,VegetableIdNotFoundException.class
	})
	
	public ResponseEntity<Object> handleIdNotFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {LoginFailedException.class})
	public ResponseEntity<Object> LoginFailedExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = {CustomerNotFoundInCityException.class})
	public ResponseEntity<Object> NotFoundInCityExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
		
	
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	static String messageFrom(BindingResult result) {		
		return result.getAllErrors().stream()
				.map(err -> err.getObjectName() + "-"+err.getDefaultMessage())
				.collect(Collectors.toList()).toString();
	}
}
