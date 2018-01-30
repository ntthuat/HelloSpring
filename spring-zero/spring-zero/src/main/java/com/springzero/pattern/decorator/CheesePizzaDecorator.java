package com.springzero.pattern.decorator;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/30/2018
 *
 */
public class CheesePizzaDecorator extends PizzaDecorator {

	public CheesePizzaDecorator(IPizza iPizza) {
		super(iPizza);
	}

	@Override
	public String doPizza() {
		String root = iPizza.doPizza();
		return root + " + " + addCheese();
	}
	
	// This is additional functionality
    // It adds cheese to an existing pizza
	private String addCheese() {
		return "Cheese";
	}
}
