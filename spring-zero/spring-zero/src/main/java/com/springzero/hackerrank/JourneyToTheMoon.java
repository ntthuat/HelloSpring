package com.springzero.hackerrank;

import java.util.Map;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 * 
 * @author Thuat T Nguyen
 * @version 06/23/2017
 */
public class JourneyToTheMoon {
	
	/**
	 * Tính giai thừa
	 */
	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}
	
	/**
	 * Tính combinations
	 * nCk = n!/(k!)/(n-k)!
	 */
	public static long combination(long n, long k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
	
	/**
	 * root - cái gốc xuất phát
	 * graph - bản đồ connect, ví dụ: {1=[], 2=[8, 9], 3=[], 4=[], 5=[], 6=[], 7=[], 8=[2], 9=[2]}
	 * visited - các node đã visit rồi, ví dụ : [false, true, false, false, false, false, false, false, false, false]
	 * count chỉ là biến tăng lên cho bài toán
	 * 
	 * output: tổng số node sẽ visit từ root.
	 */
	public static long dfs(int root, Map<Integer, Set<Integer>> graph, boolean[] visited, long count) {
        visited[root] = true;

        Set<Integer> neighbors = graph.get(root);
        for (Integer adj : neighbors) {
            if (!visited[adj]) {
                count = 1 + dfs(adj, graph, visited, count);
            }
        }

        return count;
    }
	public static long solve(int n, Map<Integer, Set<Integer>> graph) {
        long ans = 0;
        long total = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                long clusterSize = dfs(node, graph, visited, 1);
                ans+= clusterSize*total;
                total+= clusterSize;
            }
        }

        return ans;
    }
}
