package com.app.springboot.exception;

public class EmployeeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super();
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
