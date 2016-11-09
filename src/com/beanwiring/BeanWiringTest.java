package com.beanwiring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanWiringTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//BeanFactory beanFactory = (BeanFactory) context; //Chưa hiểu đoạn này tác dụng gì, vì sử dụng context để get thay cho beanFactory cũng ra kết quả giống nhau
		Student studentBean = (Student) context.getBean("studentBean");
		System.out.println("Student age: "+studentBean.getAge());  
        System.out.println("Student name: "+studentBean.getName());  
        System.out.println("Student district: "+studentBean.getAddress().getDistrict());  
        System.out.println("Student street: "+studentBean.getAddress().getStreet());  
        System.out.println("Student house number: "+studentBean.getAddress().getHouseNumber()); 
	}
}
