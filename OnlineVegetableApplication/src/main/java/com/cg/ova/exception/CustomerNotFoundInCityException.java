package com.cg.ova.exception;

public class CustomerNotFoundInCityException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundInCityException() {
		super();
	}
	
	public CustomerNotFoundInCityException(String message) {
		super(message);
	}
}
