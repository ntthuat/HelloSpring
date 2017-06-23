package com.springzero.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/domains/algorithms/arrays-and-sorting
 * 
 * @author Thuat T Nguyen
 * @version 06/23/2017
 */
public class Sorting {

	/**
	 * https://www.hackerrank.com/challenges/big-sorting
	 */
	public static void bigSorting() {
	}

	/**
	 * http://anothercasualcoder.blogspot.com/2017/05/big-sorting-hackerrank-problem.html
	 */
	public static void bubbleSort(String[] array) {

		int n = array.length;
		String temp;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1].length() > array[j].length()) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					continue;
				}
				if (array[j - 1].length() < array[j].length()) {
					continue;
				}
				if (array[j - 1].compareTo(array[j]) >= 1) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}
	}
}
