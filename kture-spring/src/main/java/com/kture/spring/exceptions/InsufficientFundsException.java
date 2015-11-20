package com.kture.spring.exceptions;

public class InsufficientFundsException extends Exception {

	public InsufficientFundsException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
