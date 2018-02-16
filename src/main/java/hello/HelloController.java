package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin
public class HelloController {
    
	@Autowired
	EventCaller eventCaller;
	
    @RequestMapping("/")
    
    public Order index() {
    	    eventCaller.callFromMain();
        return new Order ("12345", "dealer1");
    }
    
}
