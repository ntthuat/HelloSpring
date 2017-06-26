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
		// Sử dụng coparator lambda trong SortingTest cho nó nhanh
	}

	/**
	 * https://www.hackerrank.com/challenges/insertionsort1
	 */
	public static void insertionSort1(int[] array) {
		int j, temp;
		for (int i = array.length - 1; i > 0; i--) {
			j = i - 1;
			while (j >= 0 && array[j] > array[i]) {
				temp = array[i];
				array[i] = array[j];
				// code change here
				printArray(array);
				// end of code change
				array[j] = temp;
				i = j;
				j--;

			}
		}
		// code change here
		printArray(array);
		// end of code change
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
	
	/**
	 * https://www.hackerrank.com/challenges/insertionsort2
	 */
	public static void insertionSort2(int[] array) {
		int j, temp;
		// code change here
		int indexTemp = 0;
		// end of code change
		for (int i = 1; i < array.length; i++) {
			j = i - 1;
			boolean change = false;
			while (j >= 0 && array[j] > array[i]) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i = j;
				j--;
				change = true;
			}
			// code change here
			if (indexTemp==i-1) {
				printArray(array);
				indexTemp++;
			}
			// end of code change
		}
	}
}
