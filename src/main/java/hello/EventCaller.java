package hello;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EventCaller implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void callFromMain() {
		CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, "I am an event");
		publishEvent(customSpringEvent);
	}

	private void publishEvent(CustomSpringEvent customSpringEvent) {
		applicationEventPublisher.publishEvent(customSpringEvent);
	}

}