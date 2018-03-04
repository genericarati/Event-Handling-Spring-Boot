package com.somecompany.trading;

public class Order {

	public String ordernumber;
	public String dealer;
	
	public Order(String ordernumber, String dealer) {
		this.ordernumber = ordernumber;
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "Order [ordernumber=" + ordernumber + ", dealer=" + dealer + "]";
	}
}
