package com.springzero.thonghelp;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represent a node in a tree.
 * @author Hoang Thong
 */
public class Node<T> {
    
    private T data;
    private Node<T> parent = null;
    private List<Node<T>> children = new ArrayList<Node<T>>();
    
    /**
     * Construct a node with data (String)
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }
    
    /**
     * Add list of children node to parent node.
     * @param children
     */
    public void addChildren(List<Node<T>> children) {
        for (Node<T> node : children) {
            node.setParent(this);
        }
        this.children.addAll(children);
    }
    
    /**
     * Add a child node to parent node.
     * @param child
     */
    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }
    
    /**
     * Construct new child node with data and add to parent node.
     * @param data
     */
    public Node<T> addChild(T data) {
        Node<T> newChild = new Node<T>(data);
        newChild.setParent(this);
        children.add(newChild);
        return newChild;
    }
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }
    
    public boolean isRoot() {
        return parent == null;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }

}
