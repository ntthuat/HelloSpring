package com.springzero.annotation.autowired.qualifier.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FooService {

	/*@Autowired
	@Qualifier("fooFormatter")*/
	@Autowired
    @FormatterType("Foo")
	private Formatter formatter;
	
	/*@Autowired
	@Qualifier("barFormatter")*/
	@Autowired
    @FormatterType("Bar")
	private Formatter formatter2;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		FooService foo = (FooService) app.getBean("fooService");
		System.out.println(foo.formatter.format());
		System.out.println("-------------------");
		System.out.println(foo.formatter2.format());
		System.out.println("end");
	}
}
