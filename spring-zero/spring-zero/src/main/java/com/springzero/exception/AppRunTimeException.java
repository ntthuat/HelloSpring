package com.springzero.exception;

/**
 * 
 * @author tnguyen443
 * @version 10/24/2017
 */
public class AppRunTimeException {

	public static void main(String[] args) {
		final int num[] = { 1, 2, 3, 4 };
		int out = 0;
		try {
			out = num[5];
			System.out.println(out);
		} catch (RuntimeException e) {
			throw new ZeroException("Unable to print for " + out, e);
		}
	}
}
