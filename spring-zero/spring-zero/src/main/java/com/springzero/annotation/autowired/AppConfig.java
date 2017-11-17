package com.springzero.annotation.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * http://www.baeldung.com/spring-autowire
 * 
 * Ở đây có luôn ví dụ về configuration bằng anntoation. Ở dưới cùng có đoạn khá hay về Custom Qualifier, 
 * nó disambiguate where Spring inject the bean into a field, a method, a type and a parameter ( nó làm sáng tỏ nơi mà
 * Spring tiêm chích bean vào trong field, method, type hoặc parameter).
 * 
 * @author Thuat T Nguyen
 * @version 11/15/2017
 *
 */
@Configuration
@ComponentScan("com.springzero.annotation.autowired")
public class AppConfig {

	@Bean(name="fooService")
    public FooService fooService() {
        return new FooService();
    }
	
	@Bean(name="fooService")
    public FooService fooService(FooFormatter foo) {
        return new FooService(foo);
    }
	
}
