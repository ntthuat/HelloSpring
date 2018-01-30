package com.springzero.pattern.decorator;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/30/2018
 *
 */
public class PepperPizzaDecorator extends PizzaDecorator {
	public PepperPizzaDecorator(IPizza iPizza) {
		super(iPizza);
	}

	@Override
	public String doPizza() {
		String root = iPizza.doPizza();
		return root + " + " + addPepper();
	}
	
	// This is additional functionality
    // It adds pepper to an existing pizza
	private String addPepper() {
		return "Pepper";
	}
}
