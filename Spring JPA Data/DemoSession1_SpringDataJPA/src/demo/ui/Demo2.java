package demo.ui;

import org.springframework.context.support.*;
import demo.services.*;
import demo.entities.*;

import java.math.BigDecimal;
import java.util.*;

public class Demo2 {

	public static void main(String[] args) {
		
		try {
			ClassPathXmlApplicationContext ctx = 
					new ClassPathXmlApplicationContext("applicationContext.xml");
			// IOC -> spring framework
			ProductService productService = 
					(ProductService) ctx.getBean("productService");
			productService.condition1(BigDecimal.valueOf(300)).forEach(p -> {
				System.out.println("Id:" + p.getId());
				System.out.println("Name:" + p.getName());
				System.out.println("Price:" + p.getPrice());
				System.out.println("===============");
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
