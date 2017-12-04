package com.springzero.algorithms.depthfirsttraversal;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Thuat T Nguyen
 * @version 12/04/2017
 *
 */
public class Example {
	
	// Cần tạo số phần tử cho graph
	private int numberOfVertice;
	
	// Cần tạo array of list để store các element
	private LinkedList<Integer> lists[];
	
	// Constructor với tham số là số phần tử đưa vào
	public Example(final int numberOfVertice) {
		this.numberOfVertice = numberOfVertice;
		lists = new LinkedList[numberOfVertice];
		for (int i = 0; i < numberOfVertice; i++) {
			lists[i] = new LinkedList<>();
		}
	}
	
	// Function add thêm 1 element
	public void addEdge(final int v, final int w){
		lists[v].add(w);
	}
	
	// Function chính của thuật toán DFS
	private void DFSUtil(final int v, boolean visited[]){
		// Đánh dấu node hiện tại đã được visit
		visited[v] = true;
		System.out.println(v + " ");
		
		Iterator<Integer> iterator = lists[v].listIterator();
		while(iterator.hasNext()){
			int n = iterator.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	public void DFS(final int v){
		// Tạo 1 array boolean dành cho việc đánh dấu ghé thăm
		boolean visited[] = new boolean[numberOfVertice];
		
		DFSUtil(v, visited);
	}
	
	public static void main(String[] args) {
		Example graph = new Example(9);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(3, 7);
		graph.addEdge(7, 8);
		
		// starting from 0
		graph.DFS(0);
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(7);
		
		/*Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		
	}
}
