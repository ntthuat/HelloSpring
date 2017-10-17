package com.springzero.annotation.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Autowired được sử dụng khi tên biến và tên khai báo ở bean giống nhau. Nếu tên khác nhau thì phải sử dụng hàm setter.
 * 
 * @author thuat nguyen
 * @version 10/17/2017
 */
public class MainApp {
	public static void main(String[] args) {
		// Ví dụ 1: autowired ở setter
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/autowired.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
		
		/*Kết quả: Với autowired cho setter
		1. Vừa load bean lên thì TextEditor đã được khởi tạo
		2. Vừa load bean lên thì SpellChecker đã được khởi tạo
		3. Thực hiện hàm spellCheck*/
		
		// Ví dụ 2: autowired ở constructor
		/*Kết quả: Y chang ví dụ 1. Với autowired, ta không cần hàm setter cũng được*/
		
	}
}
