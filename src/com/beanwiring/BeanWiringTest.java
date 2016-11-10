package com.beanwiring;

import java.util.Map.Entry;

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
        System.out.println("-------------------------");
        /*Ví dụ về liên kết inner bean*/
        Student studentBeanSetter = (Student) context.getBean("studentBeanSetter");
        System.out.println("Student age: "+studentBeanSetter.getAge());  
        System.out.println("Student name: "+studentBeanSetter.getName());  
        System.out.println("Student district: "+studentBeanSetter.getAddress().getDistrict());  
        System.out.println("Student street: "+studentBeanSetter.getAddress().getStreet());  
        System.out.println("Student house number: "+studentBeanSetter.getAddress().getHouseNumber()); 
        System.out.println("-------------------------");
        /*Ví dụ về bean kết hợp list, map, properties*/
        Student studentListMapPro = (Student) context.getBean("studentBeanListMapPro");
        System.out.println("Student age: "+studentListMapPro.getAge());  
        System.out.println("Student name: "+studentListMapPro.getName());  
        System.out.println("Student district: "+studentListMapPro.getAddress().getDistrict());  
        System.out.println("Student street: "+studentListMapPro.getAddress().getStreet());  
        System.out.println("Student house number: "+studentListMapPro.getAddress().getHouseNumber()); 
        System.out.println("Student list: "+studentListMapPro.getBooks()); 
        System.out.println("Student map: ");
        for(Entry<String, Subject> entry:studentListMapPro.getTimeTable().entrySet()){
        	System.out.println(entry.getKey()+" - "+entry.getValue().getName());
        }
        System.out.println("Student properties: ");
        for(Object key:studentListMapPro.getHobbies().keySet()){
        	System.out.println(key+" - "+studentListMapPro.getHobbies().getProperty((String) key));
        }
	}
}
