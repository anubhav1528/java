package com.javatechie.spring.paypal.api;

public class ErrorMessage {
	String message;

	public ErrorMessage(String message) {
		super();
		this.message = message;
	}

	public ErrorMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
