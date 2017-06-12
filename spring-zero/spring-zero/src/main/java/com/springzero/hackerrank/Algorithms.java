package com.springzero.hackerrank;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Algorithms {

	/**
	 * The range of the 32-bit integer is -2^31 to 2^31-1.
	 * When we add several integer values, the resulting sum might exceed the above range. 
	 * You might need to use long long int in C/C++ or long data type in Java to store such sums. 
	 * 
	 * https://www.hackerrank.com/challenges/a-very-big-sum
	 */
	public static long sumAVeryBigSum(final int n, final long[] array) {
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += array[i];
		}

		return result;
	}

	/**
	 * Tính tổng 2 đường chéo trong array, rồi lấy 2 cái tổng này trừ nhau, rồi lấy absolute.
	 * https://www.hackerrank.com/challenges/diagonal-difference
	 */
	public static long diagonalDifference(final int n, final long[][] array) {
		long sumDiagonal1 = 0;
		long sumDiagonal2 = 0;
		for (int i = 0; i < n; i++) {
			sumDiagonal1 += array[i][i]; // diagonal from left to right
			sumDiagonal2 += array[i][n-i-1]; // diagonal from right to left
		}
		return Math.abs(sumDiagonal1-sumDiagonal2);
	}
	
	/**
	 * https://www.hackerrank.com/challenges/plus-minus
	 */
	private static double percentInArray(final String comparison, final int n, final int[] array){
		int count = 0;
		for (int i = 0; i < n; i++) {
			switch (comparison) {
			case "plus":
				if (array[i]>0) {
					count++;
				}
				break;
			case "minus":
				if (array[i]<0) {
					count++;
				}
				break;
			case "zero":
				if (array[i]==0) {
					count++;
				}
				break;
			default:
				break;
			}
		}
		final double result =(double)count/n;
		return result;
	}
	
	/**
	 * Trả về percent số dương trong array.
	 * https://www.hackerrank.com/challenges/plus-minus
	 */
	public static double percentPlusInArray(final int n, final int[] array){
		return percentInArray("plus", n, array);
	}
	
	/**
	 * Trả về percent số âm trong array.
	 * https://www.hackerrank.com/challenges/plus-minus
	 */
	public static double percentMinusInArray(final int n, final int[] array){
		return percentInArray("minus", n, array);
	}
	
	/**
	 * Trả về percent số zero trong array.
	 * https://www.hackerrank.com/challenges/plus-minus
	 */
	public static double percentZeroInArray(final int n, final int[] array){
		return percentInArray("zero", n, array);
	}
	
	/**
	 * Xây tháp bằng hash (#)
	 * https://www.hackerrank.com/challenges/staircase
	 */
	public static void staircase(final int n){
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < n; column++) {
				if (column>=n-row-1) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void bubbleSort(int[] array) {

	    int n = array.length;
	    int temp = 0;

	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {

	            if (array[j - 1] > array[j]) {
	                temp = array[j - 1];
	                array[j - 1] = array[j];
	                array[j] = temp;
	            }

	        }
	    }
	}
	
	/**
	 * Tính tổng từ start đến end trong array.<br>
	 * Ví dụ array = 1 2 3 4 5
	 * Tính tổng từ 0 đến 2 nghĩa là tính tổng element 0 và 1 = 1+2
	 */
	public static long sumArray(int start, int end, int[] array){
		long result = 0;
		for (int i = start; i < end; i++) {
			result += array[i];
		}
		return result;
	}
	
	/**
	 * https://www.hackerrank.com/challenges/mini-max-sum
	 */
	public static void minMaxSumArray4in5(int[] array){
		bubbleSort(array);
		long min = sumArray(0, array.length-1, array);
		long max = sumArray(1, array.length, array);
		System.out.println(min + " " + max);
	}
	
	public static void main(String[] args) {
		
		/*Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] ar = new long[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextLong();
		}
		long result = aVeryBigSum(n, ar);
		System.out.println(result);*/
		staircase(5);
		/*Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[][] ar = new long[n][n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			for (int ar_j = 0; ar_j < n; ar_j++) {
				ar[ar_i][ar_j] = in.nextLong();
			}
		}
		long result = diagonalDifference(n, ar);
		System.out.println(result);*/
	}
}
