package com.cg.ova.exception;

public class BillIdNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public BillIdNotFoundException() {
		super();
	}
	
	public BillIdNotFoundException(String message) {
		super(message);
	}

}
