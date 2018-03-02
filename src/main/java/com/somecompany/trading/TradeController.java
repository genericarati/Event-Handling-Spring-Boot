package com.somecompany.trading;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TradeController {


    @MessageMapping("/trade")
    @SendTo("/topic/tradeResponse")
    public TradeResponse greeting(Order order) throws Exception {
    		//do something so order is assigned to right dealership
        return new TradeResponse(order.ordernumber + " is traded!");
    }

}