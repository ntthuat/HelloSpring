package com.springzero.pattern.decorator;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/30/2018
 *
 */
public class ChickenPizza implements IPizza{

	@Override
	public String doPizza() {
		return "I am a Chicken Pizza";
	}

}