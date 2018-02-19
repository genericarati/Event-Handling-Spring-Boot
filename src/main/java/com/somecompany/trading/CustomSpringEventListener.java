package com.somecompany.trading;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

	@Override
	public void onApplicationEvent(CustomSpringEvent event) {
		System.out.println("Received custom event:-" + event.getMessage());
	}

}
