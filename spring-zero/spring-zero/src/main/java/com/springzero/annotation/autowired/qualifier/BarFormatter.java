package com.springzero.annotation.autowired.qualifier;

import org.springframework.stereotype.Component;

@Component("barFormatter")
public class BarFormatter implements Formatter {

	public BarFormatter() {
		System.out.println("Constructor trong BarFormatter đã được chạy");
	}

	@Override
	public String format() {
		return "Method format trong BarFormatter đã được chạy";
	}

}
