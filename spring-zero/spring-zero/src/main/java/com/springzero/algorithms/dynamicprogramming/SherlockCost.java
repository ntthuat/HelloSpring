package com.springzero.algorithms.dynamicprogramming;

/**
 * 
 * @author Thuat T Nguyen
 * @version 2017/12/05
 * https://www.hackerrank.com/challenges/sherlock-and-cost/forum
 *
 */
import java.util.Scanner;

public class SherlockCost {
	
	private static int n;
	
	private static int[] x = new int[100000];
	
	public static int solve(){
	    int high = 0;
	    int low = 0;
	    
	    int high_to_low_diff;
	    int low_to_high_diff;
	    
	    int low_temp;
	    int high_temp;
	    
	    for (int i = 1; i < n; i++) {
	    	high_to_low_diff = Math.abs(x[i-1] - 1);
	    	low_temp = Math.max(low, high+high_to_low_diff);
	    	
	    	low_to_high_diff = Math.abs(x[i] - 1);
	    	high_temp = Math.max(high, low+low_to_high_diff);
	    	
	    	low = low_temp;
	    	high = high_temp;
		}
	    return Math.max(low, high);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-->0) {
			n = in.nextInt();
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
			}
			System.out.println(solve());
		}
		
		/*x[0] = 100;
		x[1] = 2;
		x[2] = 100;
		x[3] = 2;
		x[4] = 100;
		n=5;
		System.out.println(solve());*/
	}
}

