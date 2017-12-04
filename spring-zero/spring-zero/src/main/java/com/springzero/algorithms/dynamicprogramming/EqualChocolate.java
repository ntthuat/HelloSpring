package com.springzero.algorithms.dynamicprogramming;

import java.util.Scanner;

public class EqualChocolate {
	
	private static int n;
	
	private static int[] x = new int[10005];
	
	public static int solve(int a){
	    int ans=0;
	    for(int i=0;i<n;i++){
	        int temp=x[i]-a;
	        ans+=temp/5+temp%5/2+temp%5%2;
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-->0) {
			n = in.nextInt();
			int min = 1000;
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
				min = Math.min(x[i], min);
			}
			int res = 1000000000;
			for (int i = 0; i < 5; i++) {
				res = Math.min(res, solve(min - i));
			}
			System.out.println(res);
		}
	}
}
