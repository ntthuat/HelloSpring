package com.springzero.hackerrank.dynamicprogramming;

import java.util.Arrays;

/**
 * <pre>
 * You have m types of coins available in infinite quantities where the value of each coin is given in the array C=[C0,C1,...,Cm-1]. 
 * Can you determine the number of ways of making change for n units using the given types of coins? 
 * For example, if m=4, and C=[8,3,1,2], we can make change for units in three ways: {1,1,1},{1,2} , and {3}.
 * Given n, m, and C, print the number of ways to make change for n units using any number of coins having the values given in C.
 * </pre>
 * 
 * @author Thuat T Nguyen
 * @version 07/18/2017
 */
public class TheCoinChangeProblem {

	static long countWays(long[] C, int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (long j = C[i]; j <= n; j++)
				table[(int)j] += table[(int)(j - C[i])];

		return table[n];
	}

	public static void main(String[] args) {
		int m = 2;
		int n = 10;
		long[] C = {3,2 };
		long count = countWays(C, m, n);
		System.out.println(count);
	}
}
