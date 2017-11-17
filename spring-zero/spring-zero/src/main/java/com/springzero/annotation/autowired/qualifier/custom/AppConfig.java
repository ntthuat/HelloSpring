package com.springzero.annotation.autowired.qualifier.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * http://www.baeldung.com/spring-autowire
 * 
 * Ở đây có luôn ví dụ về configuration bằng annoation.
 * 
 * @author Thuat T Nguyen
 * @version 11/15/2017
 *
 */
@Configuration
@ComponentScan("com.springzero.annotation.autowired.qualifier.custom")
public class AppConfig {

	@Bean(name="fooService")
    public FooService fooService() {
        return new FooService();
    }
	
}
