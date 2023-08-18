package com.cg.ova.exception;

public class CartIdNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public CartIdNotFoundException(String message) {
		super(message);
	}
	public CartIdNotFoundException() {
		super();
	}

}
