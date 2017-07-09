package com.springzero.thonghelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class use for add and process nodes in a tree.
 * @author Hoang Thong
 */
public class DataTable {
    
    private Map<Integer, Node<String>> nodes;
    private Map<String, List<String>> output;
    
    public DataTable() {
        nodes = new HashMap<>();
        output = new HashMap<>();
    }
    
    public void addRow(Integer id, String data, Integer pid) {
        if(pid == null) {
            Node<String> root = new Node<String>(data);
            nodes.put(id, root);
        }
        else {
            if (nodes.containsKey(pid)) {
                Node<String> parent = nodes.get(pid);
                Node<String> child = new Node<String>(data);
                nodes.put(id, child);
                parent.addChild(child);
            }
        }
    }
    
    public void traverseTree(Node<String>root, Node<String> node) {
        int childCount = node.getChildren().size();
        if (childCount == 0) {
            // leaf node, we're done
        } else {
            for (int i = 0; i < childCount; i++) {
                Node<String> child = node.getChildren().get(i);
                if (child.getChildren().size() > 0) {
                	root.addChildren(child.getChildren());
                    traverseTree(root,node.getChildren().get(i));
                } 
            }
        }
        
    }
    
    public Map<String, List<String>> processDataTable() {
        for (Node<String> node : nodes.values()) {
            String key = node.getData();
            traverseTree(node, node);
            List<String> children = new ArrayList<String>();
            for (Node<String> child : node.getChildren()) {
                children.add(child.getData());
            }
            output.put(key, children);
        }
        return output;
    }
}
