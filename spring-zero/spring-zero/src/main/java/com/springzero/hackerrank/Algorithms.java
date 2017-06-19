package com.springzero.hackerrank;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class này dùng để viết các method for hackerrank.com
 * 
 * @author Thuat T Nguyen
 * @version 06/13/2017
 */
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
	
	/**
	 * https://www.hackerrank.com/challenges/kangaroo
	 */
	public static String kangaroo(int x1, int v1, int x2, int v2){
		double d = (double)(x1-x2)/(v2-v1);
		String text = Double.toString(Math.abs(d));
		int integerPlaces = text.indexOf('.');
		text = text.substring(integerPlaces+1);
		if (d>0 && text.equals("0")) {
			return "YES";
		}
		return "NO";
    }
	
	/**
	 * Tìm ước số chung lớn nhất (greatest common divisor).
	 */
	private static int gcdThing(int a, int b) {
	    BigInteger b1 = BigInteger.valueOf(a); //import java.math.BigInteger;
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
	/**
	 * https://www.hackerrank.com/challenges/between-two-sets
	 */
	public static int betweenTwoSets(int[] a, int[] b){
		int lcm = getLeastCommonMultiple(a);
		int gcd = getGreatestCommonDivisor(b);
		List<Integer> listCm = getListCommonMultiple(gcd);
		bubbleSort(b);
		int count = 0;
		int i = 1;
		int numberCount = lcm*i;
		while (numberCount<b[0]) {
			numberCount = lcm*i;
			for (int j = 0; j < listCm.size(); j++) {
				if (numberCount == listCm.get(j)) {
					count++;
					break;
				}
			}
			i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		/*Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] ar = new long[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextLong();
		}*/
		/*int[] s = {1, 2, 1, 3, 2 };
		int count = birthdayChocolate(s, 3, 2);*/
		
		int[] s = {1, 7,7,7, 4, 4, 4, 5, 5, 5, 3};
		int count = getWorstPopularElement(s);
		System.out.println(count);
	}
	
	/**
	 * https://www.hackerrank.com/challenges/the-birthday-bar
	 */
	public static int birthdayChocolate(int[] s, int d, int m){
		int count = 0;
		for (int i = 0; i <= s.length-m; i++) {
			int sum = 0;
			for (int j = i; j <i+ m; j++) {
				sum+= s[j];
			}
			if (d==sum) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Viết kiểu này chạy tốn performance quá.
	 * 
	 * https://www.hackerrank.com/challenges/migratory-birds
	 */
	public static int getPopularElement(int[] a)
	{
	  int count = 1, tempCount;
	  int popular = a[0];
	  int temp = 0;
	  for (int i = 0; i < (a.length - 1); i++)
	  {
	    temp = a[i];
	    tempCount = 0;
	    for (int j = 1; j < a.length; j++)
	    {
	      if (temp == a[j])
	        tempCount++;
	    }
	    if (tempCount > count)
	    {
	      popular = temp;
	      count = tempCount;
	    }
	  }
	  return popular;
	}
	
	/**
	 * https://www.hackerrank.com/challenges/migratory-birds
	 */
	public static int getWorstPopularElement(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			boolean key = map.containsKey(a[i]);
			if (key) {
				map.put(a[i], map.get(a[i])+1);
			} else {
				map.put(a[i], 1);
			}
		}
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (Integer key : map.keySet()) {
			if (count==map.get(key) && min>key) {
				min = key;
			}
			if (count<map.get(key)) {
				min = key;
				count = map.get(key);
			}
		}
		return min;
	}
	
	public static int divisibleSumPairs(int k, int[] array) {
		int count = 0;
        for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if ((array[i]+array[j])%k==0) {
					count++;
				}
			}
		}
		return count;
    }
	
	/**
	 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records
	 */
	public static void getMaxBreakingRecords(List<Integer> list, final int number){
		if (list.isEmpty()) {
			list.add(number);
			return;
		}
		int lastIndex = list.size()-1;
		if (number>list.get(lastIndex)) {
			list.add(number);
		}
	}
	
	/**
	 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records
	 */
	public static void getMinBreakingRecords(List<Integer> list, final int number){
		if (list.isEmpty()) {
			list.add(number);
			return;
		}
		int lastIndex = list.size()-1;
		if (number<list.get(lastIndex)) {
			list.add(number);
		}
	}
	
	/**
	 * https://www.hackerrank.com/contests/w33/challenges/transform-to-palindrome
	 */
	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = 3;
		Map<Integer, Set> map = new HashMap<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int a0 = 0; a0 < k; a0++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list1.add(x);
			list2.add(y);
		}
		while (list1.size()>0) {
			addValueFrom2ListToMap(map, list1, list2);
		}
		int[] a = {1, 4, 5, 7, 9, 8, 1, 3, 10, 4, 5, 10, 2, 7, 8};
		for (int i = 0; i < a.length; i++) {
			for (Integer key: map.keySet()) {
				Set<Integer> s = map.get(key);
				for (Integer integer : s) {
					if (a[i] == integer) {
						a[i] = key;
					}
				}
				
			}
		}
		int result = findPalindrome(a);
		System.out.println(result);
	}*/
	
		// add 2 first value from 2 list to map, then remove them.
	public static void addValueFrom2ListToMap(Map<Integer, Set> map, List<Integer> list1, List<Integer> list2) {
		Set<Integer> set = new HashSet<>();
		final int key = list1.get(0);
		set.add(list1.get(0));
		set.add(list2.get(0));
		map.put(key, set);
		list1.remove(0);
		list2.remove(0);

		// add more values from 2 list to map if found
		boolean hasFound = true;
		Set<Integer> tempSet = new HashSet<>();
		loop: while (hasFound) {
			for (Integer integer : set) {
				for (int i = list1.size()-1; i >=0; i--) {
					if (list1.get(i) == (int)integer || list2.get(i) == (int) integer) {
						set.add(list1.get(i));
						set.add(list2.get(i));
						list1.remove(i);
						list2.remove(i);
					}
				}
				tempSet.add(integer);
				set.remove(integer);
				continue loop;
			}
			hasFound = false;
		}
		set.addAll(tempSet);
	}
	
	/**
	 * Sắp xếp mảng 1 theo thứ tự từ nhỏ đến lớn, còn mảng 2 là bị ảnh hưởng theo
	 */
	public static void bubbleSort2Array(int[] a, int[] b){
		int n = a.length;
	    int temp = 0;
	    int temp2 = 0;

	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {

	            if (a[j - 1] > a[j]) {
	                temp = a[j - 1];
	                temp2 = b[j - 1];
	                
	                a[j - 1] = a[j];
	                b[j - 1] = b[j];
	                
	                a[j] = temp;
	                b[j] = temp2;
	            }

	        }
	    }
	}
	
	/**
	 * https://www.youtube.com/watch?v=V-sEwsca1ak
	 */
	public static int lengthLongestPalindromicSubsequence(final int[] input){
		final int n = input.length;
		int[][] T = new int[n][n];
		for (int i = 0; i < n; i++) {
			T[i][i] = 1;
		}
		int i = 0;
		int start = 1;
		int j = start;
		start++;
		while (true) {
			if (j == n) {
				i = 0;
				j = start;
				if (j==n) {
					break;
				}
				start++;
			}
			if (input[i] == input[j]) {
				T[i][j] = T[i + 1][j - 1] + 2;
			} else {
				T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
			}
			i++;
			j++;
		}
		return T[0][n - 1];
	}
	
	public static int findPalindrome(final int[] input) {
		int[][] LP = new int[input.length][input.length];
		// LP[i][j] - length of palindrome from ith index to jth index
		// all the characters in the string are palindrome by itself of length
		// 1.
		// So all LP[i][i] = 1
		for (int i = 0; i < input.length; i++) {
			LP[i][i] = 1;
		}
		for (int sublen = 2; sublen <= input.length; sublen++) {
			for (int i = 0; i <= LP.length - sublen; i++) {
				int j = i + sublen - 1;
				if (input[i] == input[j] && sublen == 2) {
					LP[i][j] = 2;
				} else if (input[i] == input[j]) {
					LP[i][j] = LP[i + 1][j - 1] + 2;
				} else {
					LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
				}
			}
		}
		return LP[0][LP.length - 1];
	}

	public void printMatrix(int[][] LP) {
		for (int i = 0; i < LP.length; i++) {
			for (int j = 0; j < LP.length; j++) {
				System.out.print("  " + LP[i][j]);
			}
			System.out.println("");
		}
	}
	
	/**
	 * https://www.hackerrank.com/contests/w33/challenges/pattern-count
	 */
	public static int patternCount(String s){
		int count = 0;
		Pattern pattern = Pattern.compile("10+1"); //import java.util.regex.Pattern;
		Matcher matcher = pattern.matcher(s); //import java.util.regex.Matcher;
		while (matcher.find()) {
			count++;
			s = "1" + s.substring(matcher.end());
			matcher = pattern.matcher(s);
		}
		return count;
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
	
	/**
	 * Tìm ước số chung lớn nhất của nhiều số
	 */
	public static int getGreatestCommonDivisor(int[] input)
	{
		int result = input[0];
	    for(int i = 1; i < input.length; i++) result = getGreatestCommonDivisor(result, input[i]);
	    return result;
	}
	
	/**
	 * Tìm ước số chung lớn nhất của 2 ô
	 */
	public static int getGreatestCommonDivisor(int a, int b)
	{
	    while (b > 0)
	    {
	    	int temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	
	/**
	 * Tìm tất cả ước số của 1 số.
	 */
	public static List<Integer> getListCommonMultiple(int input){
		List<Integer> list = new ArrayList<>(); //import java.util.List;
											 //import java.util.ArrayList;
		for (int i = 1; i <= input / 2; i++) {
		    if (input % i == 0) {
		        list.add(i);
		    }
		}
		list.add(input);
		return list;
	}
	
	/**
	 * Tìm bội số chung nhỏ nhất của 2 số (least common multiple)
	 */
	public static int getLeastCommonMultiple(int a, int b)
	{
	    return a * (b / getGreatestCommonDivisor(a, b));
	}

	/**
	 * Tìm bội số chung nhỏ nhất của nhiều số (least common mutiple)
	 */
	public static int getLeastCommonMultiple(int[] input)
	{
		int result = input[0];
	    for(int i = 1; i < input.length; i++) result = getLeastCommonMultiple(result, input[i]);
	    return result;
	}
}
