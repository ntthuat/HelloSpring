package com.springzero.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Class này dùng để viết các method for hackerrank.com, nhưng không quan trọng, lâu lâu có thể tham khảo 1 lần.
 * 
 * @author Thuat T Nguyen
 * @version 06/21/2017
 */
public class AlgorithmsNoImportant {
	
	
	/**
	 * https://www.hackerrank.com/challenges/day-of-the-programmer
	 * @version 06/21/2017
	 */
	public static String dayOfTheProgrammer(final int year){
		if (year>1918) {
			boolean leapYear = year%400==0 || (year%4==0&&year%100!=0);
			if (leapYear) {
				return "12.09."+year;
			} else {
				return "13.09."+year;
			}
		}
		if (year<1918) {
			boolean leapYear = year%4==0;
			if (leapYear) {
				return "12.09."+year;
			} else {
				return "13.09."+year;
			}
		}
		return "26.09.1918";
	}
	
	//////////////////////////////////////////////////////////////////////////
	
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
	
	//////////////////////////////////////////////////////////////////////////
	
	/**
	 * https://www.hackerrank.com/challenges/bon-appetit
	 */
	public static int bonAppetit(int k, int b, int[] array){
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		sum = sum - array[k];
		int moneyEachPerson = sum/2;
		int charge = b - moneyEachPerson;
		return charge;
	}
	
	//////////////////////////////////////////////////////////////////////////
	
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
	
	//////////////////////////////////////////////////////////////////////////
	
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
	
	//////////////////////////////////////////////////////////////////////////
	
	/**
	 * https://www.hackerrank.com/challenges/sock-merchant
	 */
	public static int sockMerchant(int[] array) {
		int count = 0;
		List<Integer> list = new ArrayList<>();
		list.add(array[0]);
		loop: for (int i = 1; i < array.length; i++) {
			if (list.size() == 0) {
				list.add(array[i]);
				continue;
			}
			for (int j = list.size() - 1; j >= 0; j--) {
				if ((int) list.get(j) == array[i]) {
					count++;
					list.remove(j);
					continue loop;
				}
			}
			list.add(array[i]);
		}
		return count;
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	/**
	 * https://www.hackerrank.com/challenges/drawing-book
	 * @version 06/21/2017
	 */
	public static int drawingBook(final int targetPage, int totalPage){
		final int numberFromStart = targetPage/2;
		if (totalPage%2==0) {
			totalPage++;
		}
		final int numberFromEnd = (totalPage-targetPage)/2;
        return Math.min(numberFromStart, numberFromEnd);
    }
	
	//////////////////////////////////////////////////////////////////////////
	
	/**
	 * https://www.hackerrank.com/challenges/counting-valleys
	 */
	public static int countingValleys(final String string){
		int count = 0;
		int seaLevel = 0;
		boolean up = false;
		boolean down = false;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i)=='U') {
				seaLevel++;
			}
			if (string.charAt(i)=='D') {
				seaLevel--;
			}
			if (seaLevel==0) {
				if (down) {
					count++;
				}
				up = false;
				down = false;
			} else if (seaLevel>0) {
				up = true;
			} else if (seaLevel<0) {
				down = true;
			}
		}
		return count;
	}
}
