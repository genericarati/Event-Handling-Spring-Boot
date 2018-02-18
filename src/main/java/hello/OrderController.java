package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	EventCaller eventCaller;

	@RequestMapping("/dealer1")
	public List<Order> getDealer1() {
//		eventCaller.callFromMain();
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("order1","dealer1"));
		orders.add(new Order("order2","dealer1"));
		return orders; 
	}
	
	@RequestMapping("/dealer2")
	public List<Order> getDealer2() {
//		eventCaller.callFromMain();
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("order3","dealer2"));
		orders.add(new Order("order4","dealer2"));
		return orders; 
	}

}
