package com.somecompany.trading;

public class TradeRequest {

	public Order order;
	public String requestor;

	public TradeRequest(){
		
	}
	public TradeRequest(Order order, String requestor) {
		this.order = order;
		this.requestor = requestor;
	}
	@Override
	public String toString() {
		return "TradeRequest [order=" + order.toString() + ", requestor=" + requestor + "]";
	}
	
}
