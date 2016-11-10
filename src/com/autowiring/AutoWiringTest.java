package com.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		LaptopStore laptopStore = (LaptopStore) applicationContext.getBean("laptopStore");
		System.out.println("Laptop 1 trade mark: " +laptopStore.getLaptop1().showTradeMark());
		System.out.println("Laptop 2 trade mark: " +laptopStore.getLaptop2().showTradeMark());
		System.out.println("+++++++++++++++++++++++++++++++");
		/*+++++++++++++++++++++++++++++++++++++*/
		LaptopStore2 laptopStore2 = (LaptopStore2) applicationContext.getBean("laptopStore2");
		System.out.println("Laptop 1 trade mark: " +laptopStore2.getLaptop1().showTradeMark());
		System.out.println("Laptop 2 trade mark: " +laptopStore2.getLaptop2().showTradeMark());
		System.out.println("+++++++++++++++++++++++++++++++");
		/*+++++++++++++++++++++++++++++++++++++*/
		LaptopStore3 laptopStore3 = (LaptopStore3) applicationContext.getBean("laptopStore3");
		System.out.println("Laptop 1 trade mark: " +laptopStore3.getLaptop1().showTradeMark());
		System.out.println("Laptop 2 trade mark: " +laptopStore3.getLaptop2().showTradeMark());
		System.out.println("+++++++++++++++++++++++++++++++");
		/*+++++++++++++++++++++++++++++++++++++*/
	}
}
