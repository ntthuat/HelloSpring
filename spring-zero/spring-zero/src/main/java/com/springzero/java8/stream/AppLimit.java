package com.springzero.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Run thử function stream().limit()
 * 
 * @author tnguyen443
 * @version 10/23/2017
 */
public class AppLimit {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,3,5,7,9,12,15,19,20,2);
		numbers.stream().limit(5).forEach(System.out::println); // Print ra 1,3,4,5,9 theo thứ tự
	}
}
