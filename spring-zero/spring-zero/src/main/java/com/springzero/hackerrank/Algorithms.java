package com.springzero.hackerrank;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Algorithms {

	/**
	 * The range of the 32-bit integer is -2^31 to 2^31-1.
	 * When we add several integer values, the resulting sum might exceed the above range. 
	 * You might need to use long long int in C/C++ or long data type in Java to store such sums. 
	 * 
	 * https://www.hackerrank.com/challenges/a-very-big-sum
	 */
	public static long sumAVeryBigSum(final long[] array) {
		final int n = array.length;
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
	public static long diagonalDifference(final long[][] array) {
		final int n = array.length;
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
	private static double percentInArray(final String comparison, final int[] array){
		final int n = array.length;
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
	public static double percentPlusInArray(final int[] array){
		return percentInArray("plus", array);
	}
	
	/**
	 * Trả về percent số âm trong array.
	 * https://www.hackerrank.com/challenges/plus-minus
	 */
	public static double percentMinusInArray(final int[] array){
		return percentInArray("minus", array);
	}
	
	/**
	 * Trả về percent số zero trong array.
	 * https://www.hackerrank.com/challenges/plus-minus
	 */
	public static double percentZeroInArray(final int[] array){
		return percentInArray("zero", array);
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
	
	/**
	 * https://www.hackerrank.com/challenges/birthday-cake-candles
	 */
	public static int countMaxArray(final long[] array){
		final int n = array.length;
		int count = 1;
		long max = array[0];
		for (int i = 1; i < n; i++) {
			if (max < array[i]) {
				max = array[i];
				count = 1;
			} else if (max==array[i]) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
	 * Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
	 * https://www.hackerrank.com/challenges/time-conversion
	 */
	public static String convert12hourTo24hour(String time){
		SimpleDateFormat time12hourFormat = new SimpleDateFormat("hh:mm:ss a");
		SimpleDateFormat time24hourFormat = new SimpleDateFormat("HH:mm:ss");
	    final String tailTime = time.substring(7);
	    if (time.charAt(0)!=' ') {
			time = time.substring(0, 8) + " " + time.substring(8);
		}
	    Date date = null;
		try {
			date = time12hourFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time24hourFormat.format(date);
	}
	
	/**
	 * https://www.hackerrank.com/challenges/grading
	 */
	public static int[] gradingStudents(int[] grades){
		for (int i = 0; i < grades.length; i++) {
			if (grades[i]<38) {
				continue;
			} else {
				int a = grades[i]%5;
				grades[i] += a>=3 ? 5-a : 0;
			}
		}
		return grades;
	}
	
	/**
	 * https://www.hackerrank.com/challenges/apple-and-orange
	 */
	public static void appleAndOrange(int s, int t, int a, int b, int[] apples, int[] oranges){
		int countApple = 0;
		int countOrange = 0;
		for (int apple : apples) {
			if (a+apple>=s && a+apple<=t) {
				countApple++;
			}
		}
		for (int orange : oranges) {
			if (b+orange>=s && b+orange<=t) {
				countOrange++;
			}
		}
		System.out.println(countApple);
		System.out.println(countOrange);
	}
	
	/**
	 * https://www.hackerrank.com/contests/w33/challenges/twin-arrays
	 */
	public static int twinArrays(int[] array1, int[] array2) {
		int sum = 0;
		array1 = getTwoLowestKeepIndex(array1);
		array2 = getTwoLowestKeepIndex(array2);
		if (array1[1] != array2[1]) {
			sum = array1[0] + array2[0];
		} else {
			int sum1 = array1[0] + array2[2];
			int sum2 = array1[2] + array2[0];
			sum = sum1 > sum2 ? sum2 : sum1;
		}
		return sum;
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
		int[] array1 ={5, 4,10, 3, 6, 1};
		int[] array2 ={5, 4,2, 3, 2, 1};
		int sum =  twinArrays(array1,array2);
		System.out.println(sum);
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
	
	private static int[] getTwoLowestKeepIndex(int[] array) {
	    int[] lowestValues = new int[2];
	    int[] lowestValuesIndex = new int[2];
	    Arrays.fill(lowestValues, Integer.MAX_VALUE);
	    
	    for (int i = 0; i < array.length; i++) {
	    	if(array[i] < lowestValues[1]) {
	            lowestValues[1] = array[i];
	            lowestValuesIndex[1] = i;
	            if (lowestValues[0]>lowestValues[1]) {
	            	
	            	// swap lowestValues
	            	int temp = lowestValues[0];
	            	lowestValues[0] = lowestValues[1];
	            	lowestValues[1] = temp;
	            	
	            	// swap lowestValuesIndex
	            	temp = lowestValuesIndex[0];
	            	lowestValuesIndex[0] = lowestValuesIndex[1];
	            	lowestValuesIndex[1] = temp;
				}
	        }
		}
	    int[] result = {lowestValues[0],lowestValuesIndex[0],lowestValues[1],lowestValuesIndex[1]};
	    return result;
	}

	private static int[] getTwoLowest(int[] array) {
	    int[] lowestValues = new int[2];
	    Arrays.fill(lowestValues, Integer.MAX_VALUE);

	    for(int n : array) {
	        if(n < lowestValues[1]) {
	            lowestValues[1] = n;
	            Arrays.sort(lowestValues);
	        }
	    }
	    return lowestValues;
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
}
