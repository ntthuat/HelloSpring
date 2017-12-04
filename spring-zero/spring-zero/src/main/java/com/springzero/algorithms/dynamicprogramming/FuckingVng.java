package com.springzero.algorithms.dynamicprogramming;

public class FuckingVng {
	private static int max(int x, int y, int z, int value)
    {
        int max = x;
        if (Math.abs(value-y)==10) {
			if (max<y) {
				max = y;
			}
		}
        
        if (Math.abs(value-z)==10) {
			if (max<z) {
				max = z;
			}
		}
        return max;
    }
 
    private static int maxCost(int cost[][], int m, int n) {
        int i, j;
        int total[][]=new int[m+1][n+1];
 
        total[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            total[i][0] = total[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            total[0][j] = cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++){
            for (j = 1; j <= n; j++){
            	int rightValue = 0;
        		int leftValue = 0;
        		if (j-1>=0) {
        			leftValue = total[i-1][j-1];
				}
        		if (j+1<=n) {
        			rightValue = total[i-1][j+1];
				}
                total[i][j] = max(total[i-1][j], 
                				  leftValue, 
                				  rightValue,
                				  cost[i][j]) + cost[i][j];
            }
        }
        int max = total[n][0];
        for (int k = 1; k <= n; k++) {
			if (max<total[n][k]) {
				max = total[n][k];
			}
		}
        return max;
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{70, 20, 30},
                       {40, 80, 20},
                       {10, 50, 30}};
        System.out.println("minimum cost to reach (2,2) = " +
        		maxCost(cost,2,2));
    }
}
