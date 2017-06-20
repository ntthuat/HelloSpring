package com.springzero.hackerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.xml.soap.Node;


/**
 * https://www.hackerrank.com/contests/w33/challenges/transform-to-palindrome/problem
 * Thuật toán Depth First Traversal:
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * 
 * @author Thuat T Nguyen
 * @version 06/19/2017
 */
public class TransformToPalindrome {
	private int V;   // No. of vertices
	public int[] mark;

	// Array of lists for Adjacency List Representation
	public List<Integer> adj[];

	// Constructor
	TransformToPalindrome(int v) {
		V = v;
		mark = new int[v];
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	private void DFSUtil(int v, int cc, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		mark[v] = cc;
		/*System.out.print(v + " ");*/
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]){
				DFSUtil(n,cc, visited);
			}
				
		}
	}

	public void DFS(int v, int cc){
		
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];
		
		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, cc, visited);
	}

	public static int findPalindrome(final int[] input, final int[] mark) {
		int[][] LP = new int[input.length][input.length];
		for (int i = 0; i < input.length; i++) {
			LP[i][i] = 1;
		}
		for (int sublen = 2; sublen <= input.length; sublen++) {
			for (int i = 0; i <= LP.length - sublen; i++) {
				int j = i + sublen - 1;
				if (mark[input[i]] == mark[input[j]] && sublen == 2) {
					LP[i][j] = 2;
				} else if (mark[input[i]] == mark[input[j]]) {
					LP[i][j] = LP[i + 1][j - 1] + 2;
				} else {
					LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
				}
			}
		}
		return LP[0][LP.length - 1];
	}
	
	public static void printMatrix(int[][] LP) {
		for (int i = 0; i < LP.length; i++) {
			for (int j = 0; j < LP.length; j++) {
				System.out.print("  " + LP[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		TransformToPalindrome g = new TransformToPalindrome(4);

		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		
		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
		int cc = 1;
		for (int i = 0; i < 4; i++) {
			if (g.mark[i]==0) {
				g.DFS(i,cc);
				cc++;
			}
		}
		
		for (int i = 0; i < g.mark.length; i++) {
			System.out.println(g.mark[i]);
		}
		
	}
}
