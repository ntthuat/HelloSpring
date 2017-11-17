package com.springzero.annotation.autowired.qualifier.custom;

import org.springframework.stereotype.Component;

@Component
@FormatterType("Bar")
public class BarFormatter implements Formatter {

	public BarFormatter() {
		System.out.println("Constructor trong BarFormatter đã được chạy");
	}

	@Override
	public String format() {
		return "Method format trong BarFormatter đã được chạy";
	}

}
