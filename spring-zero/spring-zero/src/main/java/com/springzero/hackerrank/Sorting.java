package com.springzero.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

	// PART 1: INSERTION SORT
	
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

	public static void printArray(int[] ar) {
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
			while (j >= 0 && array[j] > array[i]) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i = j;
				j--;
			}
			// code change here
			if (indexTemp==i-1) {
				printArray(array);
				indexTemp++;
			}
			// end of code change
		}
	}
	
	/**
	 * https://www.hackerrank.com/challenges/correctness-invariant
	 */
	public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            while(j >= 0 && array[j] > array[i]){
            	int temp = array[i];
                array[j + 1] = array[j];
                array[j] = temp;
                i = j;
                j--;
            }
        }

        printArray(array);
    }
	
	/**
	 * https://www.hackerrank.com/challenges/runningtime
	 */
	public static void runningTimeAlgorithms(int[] array){
		// code change here
		int count = 0;
		// end of code change
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            while(j >= 0 && array[j] > array[i]){
            	count++;
            	int temp = array[i];
                array[j + 1] = array[j];
                array[j] = temp;
                i = j;
                j--;
            }
        }
        // code change here
        System.out.println(count);
        // end of code change
    }
	
	///////////////////////////////////////////////////////////////
	
	// PART 2: QUICK SORT
	
	/**
	 * https://stackoverflow.com/questions/14907334/stackoverflow-with-quicksort-java-implementation
	 */
	public static void qsort(int[] a, int si, int ei) {
		// base case
		if (si >= ei) {
		} else {
			int pivot = a[si];
			int i = si + 1;

			// partition array
			for (int j = si + 1; j <= ei; j++) {
				if (pivot > a[j]) {
					swap(a,i,j);
					i++;
				}
			}

			// put pivot in right position
			a[si] = a[i - 1];
			a[i - 1] = pivot;

			// call qsort on right and left sides of pivot
			qsort(a, si, i - 2);
			qsort(a, i, ei);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
