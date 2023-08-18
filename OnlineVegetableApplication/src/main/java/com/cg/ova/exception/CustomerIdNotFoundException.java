package com.cg.ova.exception;

public class CustomerIdNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomerIdNotFoundException() {
		super();
	}
	
	public CustomerIdNotFoundException(String message) {
		super(message);
	}

}
