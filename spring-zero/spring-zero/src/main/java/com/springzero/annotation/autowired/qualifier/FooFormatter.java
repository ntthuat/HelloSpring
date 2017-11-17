package com.springzero.annotation.autowired.qualifier;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter implements Formatter {

	public FooFormatter() {
		System.out.println("Constructor trong FooFormatter đã được chạy");
	}

	@Override
	public String format() {
		return "Method format trong FooFormatter đã được chạy";
	}

}
