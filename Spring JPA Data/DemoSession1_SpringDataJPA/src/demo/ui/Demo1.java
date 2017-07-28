package demo.ui;

import org.springframework.context.support.*;
import demo.services.*;
import demo.entities.*;
import java.util.*;

public class Demo1 {

	public static void main(String[] args) {
		
		try {
			ClassPathXmlApplicationContext ctx = 
					new ClassPathXmlApplicationContext("applicationContext.xml");
			// IOC -> spring framework
			CategoryService categoryService = 
					(CategoryService) ctx.getBean("categoryService");
			for(Category category : categoryService.findAll()) {
				System.out.println("Id: " + category.getId());
				System.out.println("Name: " + category.getName());
				System.out.println("=====================");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
