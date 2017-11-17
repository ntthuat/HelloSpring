package com.springzero.annotation.autowired;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter {
 
	public FooFormatter() {
		System.out.println("Constructor trong FooFormatter đã được chạy");
	}
	
    public String format() {
        return "Method format trong FooFormatter đã được chạy";
    }
}
