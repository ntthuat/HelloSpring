package com.springzero.exception;

/**
 * ArrayIndexOutOfBoundsException 
 * extends IndexOutOfBoundsException 
 * extends RunTimeException
 * 
 * @author tnguyen443
 * @version 10/24/2017
 */
public class AppArrayIndexOutOfBoundsException {
	
	public static void main(String[] args) {
		// Ở đây sẽ throw ArrayIndexOutOfBoundsException
		int num[] = { 1, 2, 3, 4 };
		System.out.println(num[5]);
	}
}
