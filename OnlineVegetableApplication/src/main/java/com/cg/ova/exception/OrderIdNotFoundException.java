package com.cg.ova.exception;

public class OrderIdNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	String s;
	public OrderIdNotFoundException() {
		super();
	}
	public OrderIdNotFoundException(String message) {
		super(message);
	}

}
