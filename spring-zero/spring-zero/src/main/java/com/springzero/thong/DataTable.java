package com.springzero.thong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataTable {
	
	private Map<String, List<String>> graph;
	private Map<String, String> connection;
	private int totalNode = 0;
	public DataTable() {
		graph = new HashMap<>();
		connection = new HashMap<>();
	}
	
	private void addRow(final String id,final String name,final String pid){
		if (pid!=null) {
			if (graph.get(pid)==null) {
				List<String> list = new LinkedList<>();
				list.add(id);
				graph.put(pid, list);
			} else {
				graph.get(pid).add(id);
			}
		}
		connection.put(id, name);
		totalNode++;
	}
	
	private static long dfs(String root, Map<String, List<String>> graph, boolean[] visited, long count) {
        visited[Integer.parseInt(root)] = true;

        List<String> neighbors = graph.get(root);
        if (neighbors==null) {
			return 0;
		}
        for (String adj : neighbors) {
            if (!visited[Integer.parseInt(adj)]) {
            	graph.get(root).add(adj);
                count = 1 + dfs(adj, graph, visited, count);
            }
        }

        return count;
    }
	
	private void processDataTable() {
        /*long ans = 0;

        boolean[] visited = new boolean[totalNode];
        for (int node = 0; node < totalNode; node++) {
            if (!visited[node]) {
                long clusterSize = dfs(Integer.toString(node), graph, visited, 1);
            }
        }*/
		List<String> parent = new ArrayList<>();
		for(String key : graph.keySet()){
			List<String> list = graph.get(key);
			getAllChild(list, parent);
		}
        for (int i = 0; i < totalNode; i++) {
			List<String> list = graph.get(Integer.toString(i));
			if (list==null) {
				
			}
		}

    }
	public List<String> getAllChild(List<String> list,List<String> parent){
		for(int i= 0;i<list.size();i++){
			if(graph.containsKey(list.get(i))){
				getAllChild(graph.get(list.get(i)),parent);
				
				
			}else {
				parent.add(list.get(i));
			}
		}
		return parent; 
	}
	public static void main(String[] args) {
		DataTable dt = new DataTable();
		dt.addRow("0", "A", null);
		dt.addRow("1", "B", "0");
		dt.addRow("2", "C", "0");
		dt.addRow("4", "D", "1");
		dt.addRow("5", "E", "1");
		dt.addRow("6", "F", "4");
		dt.addRow("3", "G", "0");
		dt.processDataTable();
		System.out.println("end");
	}
	
}
