package com.springzero.hackerrank.weekofcode44;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Thuat T Nguyen
 * @version 06/18/2017
 */
public class MaximumGcdAndSum {

	private static Set<Integer> set1 = new HashSet<>();
	private static Set<Integer> set2 = new HashSet<>();
	
	public static void findAllFactors(int n) {
		set1.add(n);
		int i = 2;
		while (i <= Math.sqrt(n)) {
			if (n % i == 0) {
				System.out.println(i);
				set1.add(i);
				if (i != (n / i)) {
					System.out.println(n / i);
					set1.add(n/i);
				}
			}
			i++;
		}
	}

	public static void main(String[] args) {
		int[] A = { 3, 1, 4, 2, 8 };
		int[] B = { 5, 2, 12, 8, 3 };
		set1.add(1);
		set2.add(1);
		findAllFactors(10);
	}

}
