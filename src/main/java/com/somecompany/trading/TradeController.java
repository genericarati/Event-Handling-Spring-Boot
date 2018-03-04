package com.somecompany.trading;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TradeController {


    @MessageMapping("/trade")
    @SendTo("/topic/tradeResponse")
    public TradeResponse returnTradeResponse(TradeRequest request) throws Exception {
    		System.out.println("test-"+request.toString());
        return new TradeResponse(request.order.ordernumber + " is traded!");
    }

}