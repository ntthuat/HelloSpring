package com.springzero.hackerrank.dynamicprogramming;

/**
 * @author Thuat T Nguyen
 * @version 07/11/2017
 */
public class OverlappingSubproblems {
	
	private int fibMem[];
	private int N;
	
	OverlappingSubproblems(int n){
		fibMem = new int[n];
		N = n;
	}
	
	public int fibonacci(int n) {
		int r = 1;
		if(fibMem[n - 1] != 0) {
			r = fibMem[n - 1];
		} else {
			if(n > 2) {
				r = fibonacci(n - 1) + fibonacci(n - 2);
			}
			fibMem[n - 1] = r;
		}
		return r;
	}
	
	void printFibonacci() {
		fibonacci(N);
	    int i;
	    for(i = 1; i <= fibMem.length; i++) {
	    	System.out.println("fibonacci("+i+"): "+fibMem[i - 1]);
	    }
	}
	
	/**
	 * Đây là method fibonacci bình thường
	 */
	public static long fibonacciNormal(int n) {
        if (n <= 1) return n;
        else return fibonacciNormal(n-1) + fibonacciNormal(n-2);
    }

	
	public static void main(String[] args) {
		/*System.out.println(fibonacciNormal(10));*/
		OverlappingSubproblems o = new OverlappingSubproblems(5);
		o.printFibonacci();
	}
}
