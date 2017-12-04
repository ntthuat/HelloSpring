package com.springzero.algorithms.dynamicprogramming;

/**
 * 
 * @author Thuat T Nguyen
 * @version 12/04/2017
 *
 */
public class Fibonacci {
	// Tạo 1 array để store giá trị của từng value
	private static int array[];
	
	// Tổng số element
	private static int number;

	private static void init(final int n) {
		number = n;
		array = new int[n];
	}
	
	public static int getFibonacci(final int n){
		init(n);
		return fibonacci(n);
	}
	
	private static int fibonacci(int n){
		int result = 1;
		if (array[n-1]!=0) { // Nếu giá trị đang xét khác 0, nghĩa là nó đã được tính toán, gán r vào giá trị này
			result = array[n-1];
		} else {
			if(n > 2) {
				result = fibonacci(n-1)+fibonacci(n-2);
			}
			array[n - 1] = result;
		}
		return result;
	}
	
	public static void printFibonacci(final int n) {
		init(n);
		fibonacci(n);
		int i;
	    for(i = 1; i <= array.length; i++) {
	    	System.out.println("fibonacci("+i+"): "+array[i - 1]);
	    }
	}
	
	public static void main(String[] args) {
		/*int test = Fibonacci.getFibonacci(6);*/
		Fibonacci.printFibonacci(6);
		
	}
}
