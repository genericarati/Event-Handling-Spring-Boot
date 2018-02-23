package com.somecompany.trading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	EventCaller eventCaller;

	private List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@RequestMapping("/dealer1")
	public List<Order> getDealer1() {
		// eventCaller.callFromMain();
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("order1", "dealer1"));
		orders.add(new Order("order2", "dealer1"));
		return orders;
	}

	@RequestMapping("/dealer2")
	public List<Order> getDealer2() {
		// eventCaller.callFromMain();
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("order3", "dealer2"));
		orders.add(new Order("order4", "dealer2"));
		return orders;
	}

	@RequestMapping(value = "/requestTrade", method = RequestMethod.POST)
	public ResponseEntity<String> requestTrade(@RequestBody Order order) {
		ResponseEntity<String> response;
		try {
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	

}
