package com.somecompany.trading;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String message;

	public CustomSpringEvent(Object source, String message) {
		super(source);
		this.message = message;
		System.out.println("Custom spring event object is created");
	}

	public String getMessage() {
		return message;
	}

}


