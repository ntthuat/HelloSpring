package com.springzero.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FooService {
     
    /*@Autowired*/ //Cái này là autowired by name
    private FooFormatter fooFormatter;
    /**
     * Câu autowired ở trên tương đương xml
     * <bean id="fooFormatter" class="com.springzero.annotation.autowired.FooService" autowire="byName"></bean>
     * 
     */
 
    @Autowired //Cái này là autowired by type
	public void setFooFormatter(FooFormatter fooFormatter) {
		this.fooFormatter = fooFormatter;
	}
    /**
     * Câu autowired ở trên tương đương xml
     * <bean id="fooFormatter" class="com.springzero.annotation.autowired.FooService" autowire="byType"></bean>
     * 
     */
    
	/*@Autowired*/ //Cái này là autowired dùng constructor, tuy nhiên trong AppConfig phải khai báo thêm)
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
	public FooService() {
    }
	/**
     * Câu autowired ở trên tương đương xml
     * <bean id="fooFormatter" class="com.springzero.annotation.autowired.FooService" autowire="constructor"></bean>
     * 
     */
    
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext app =  new AnnotationConfigApplicationContext(AppConfig.class);
    	FooService foo = (FooService) app.getBean("fooService");
    	System.out.println(foo.fooFormatter.format());
    	System.out.println("end");
	}
}
