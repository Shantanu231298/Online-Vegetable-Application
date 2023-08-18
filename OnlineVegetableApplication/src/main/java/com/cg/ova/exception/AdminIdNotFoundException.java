package com.cg.ova.exception;

public class AdminIdNotFoundException  extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AdminIdNotFoundException() {
		super();
	}
	
	public AdminIdNotFoundException(String message) {
		super(message);
	}
}
