package com.cachedemo;

import java.util.List;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheTest {
/*	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Repository repository = (Repository) context.getBean("repository");
		for (int i = 0; i < 10; i++) {
			if (i==5) {
				repository.clearCache();
			}
			List<String> names = repository.getNameList();
			System.out.println("Size: "+names.size());
		}
	}*/
}
