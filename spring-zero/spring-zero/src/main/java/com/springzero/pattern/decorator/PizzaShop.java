package com.springzero.pattern.decorator;

/**
 * 
 * @author Thuat T Nguyen
 * @version 01/30/2018
 *
 */
public class PizzaShop {
	
	public static void main(String[] args) {
		IPizza tomato = new TomatoPizza();
		IPizza chicken = new ChickenPizza();

		System.out.println(tomato.doPizza());
		System.out.println(chicken.doPizza());
		
		// Use Decorator pattern to extend existing pizza dynamically

        // Add pepper to tomato-pizza
        PepperPizzaDecorator pepperDecorator = new PepperPizzaDecorator(tomato);
        System.out.println(pepperDecorator.doPizza());

        // Add cheese to tomato-pizza
        CheesePizzaDecorator cheeseDecorator = new CheesePizzaDecorator(tomato);
        System.out.println(cheeseDecorator.doPizza());

        // Add cheese and pepper to tomato-pizza
        // We combine functionalities together easily.
        CheesePizzaDecorator cheeseDecorator2 = new CheesePizzaDecorator(pepperDecorator);
        System.out.println(cheeseDecorator2.doPizza());
        
        PepperPizzaDecorator pepperDecorator2 = new PepperPizzaDecorator(cheeseDecorator2);
        System.out.println(pepperDecorator2.doPizza());
	}
}
