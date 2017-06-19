package com.springzero.hackerrank;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * https://www.hackerrank.com/contests/w33/challenges/transform-to-palindrome/problem
 * Thuật toán Depth First Traversal:
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * 
 * @author Thuat T Nguyen
 * @version 06/19/2017
 */
public class TransformToPalindrome {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	TransformToPalindrome(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	private void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	public static void main(String[] args) {
		TransformToPalindrome g = new TransformToPalindrome(6);

		g.addEdge(5, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}
}
