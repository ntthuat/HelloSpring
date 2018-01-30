package com.springzero.pattern.decorator;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/30/2018
 *
 */
public abstract class PizzaDecorator implements IPizza{
	
	// Reference to component object
	protected IPizza iPizza;
	
	public PizzaDecorator(IPizza iPizza) {
		this.iPizza = iPizza;
	}

	public IPizza getiPizza() {
		return iPizza;
	}

	public void setiPizza(IPizza iPizza) {
		this.iPizza = iPizza;
	}
}
