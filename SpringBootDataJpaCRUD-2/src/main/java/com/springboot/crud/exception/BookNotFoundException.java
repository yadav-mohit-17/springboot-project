package com.springboot.crud.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String message) {
		super(message);
	}

}
