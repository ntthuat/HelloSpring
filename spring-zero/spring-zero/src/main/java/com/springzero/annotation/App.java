package com.springzero.annotation;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author tnguyen443
 * @version 10/19/2017
 */
public class App {
	
	public static void main(String[] args) {
		Student st = new Student();
		
		/*Hibernate_Table table = st.getClass().getAnnotation(Hibernate_Table.class);
		System.out.println(table.value());
		
		Hibernate_Field[] fields = st.getClass().getAnnotationsByType(Hibernate_Field.class);
		for (Hibernate_Field field : fields) {
			System.out.println(field.value());
		}*/
		System.out.println("end");
	}
}
