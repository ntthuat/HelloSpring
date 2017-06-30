package com.springzero.thong;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataTable {
	
	private Map<String, List<String>> graph;
	private Map<String, List<String>> output;
	private Map<String, String> connection;
	private int totalNode = 0;
	public DataTable() {
		graph = new HashMap<>();
		output = new HashMap<>();
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
		output.put(name, new LinkedList<>());
		connection.put(id, name);
		totalNode++;
	}
	
	private void dfs(String root, String node) {
        List<String> neighbors = graph.get(node);
        if (neighbors==null) {
			return;
		}
        for (String adj : neighbors) {
            output.get(connection.get(root)).add(connection.get(adj));
            dfs(root, adj);
        }

    }
	
	private void processDataTable() {
        for (int root = 0; root < totalNode; root++) {
        	dfs(Integer.toString(root),Integer.toString(root));
        }
        for (Entry<String, List<String>> entry : output.entrySet()){
        	if (!entry.getValue().isEmpty()) {
        		System.out.println(entry.getKey() + "=" + entry.getValue());
			} else {
				System.out.println(entry.getKey() + "=null");
			}
        }
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
	}
	
}
