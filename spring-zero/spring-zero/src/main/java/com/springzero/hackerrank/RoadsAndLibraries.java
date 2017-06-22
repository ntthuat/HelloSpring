package com.springzero.hackerrank;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/torque-and-development
 * Editorial: https://lucaslouca.com/roads-and-libraries-challenge
 * 
 * @author Thuat T Nguyen
 * @version 06/22/2017 01:10AM
 */
public class RoadsAndLibraries {
	
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
	public static long solve(int n, int m, long clib, long croad, Map<Integer, Set<Integer>> graph) {
        long ans = 0;

        boolean[] visited = new boolean[n + 1];
        for (int node = 1; node <= n; node++) {
            if (!visited[node]) {
                long clusterSize = dfs(node, graph, visited, 1);

                ans += clib;
                if (clib > croad) {
                    ans += ((clusterSize - 1) * croad);
                } else {
                    ans += ((clusterSize - 1) * clib);
                }
            }
        }

        return ans;
    }
}
