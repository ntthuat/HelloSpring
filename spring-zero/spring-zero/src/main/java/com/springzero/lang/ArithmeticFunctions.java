package com.springzero.lang;

/**
 * 
 * @author Maximus
 * @version 2017/12/13
 *
 */
public class ArithmeticFunctions {
	
	/**
	 * Example: String s = leftZeroPadding(5,9);
	 * Result: s = "00009"
	 */
	public static String leftZeroPadding(final int length, final int number){
		final String pattern = "%0" + length +"d";
		final String number_string = String.valueOf(number);
		return String.format(pattern, Integer.parseInt(number_string));
	}
	
	public static void main(String[] args) {
		int i = 9;
		String s = leftZeroPadding(5,i);
		System.out.println(s);
	}
}
