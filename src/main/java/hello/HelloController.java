package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
	@Autowired
	EventCaller eventCaller;
	
    @RequestMapping("/")
    public String index() {
    	    eventCaller.callFromMain();
        return "Greetings from Spring Boot!";
    }
    
}
