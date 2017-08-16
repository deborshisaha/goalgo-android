package com.algorithms.linkedlist;

import com.algorithms.Node;

public class LinkedList {

    private Node lastNode = null;
    private Node firstNode = null;
    private int count = 0;
    
    // Add
    public boolean add(Node node) {

        if (firstNode == null) {
            firstNode = node;
        }

        if (lastNode == null) {
            lastNode = node;
        } else {
            lastNode.next = node;
            lastNode = node;
        }
        count++;
        return true;
    }

    // Delete
    public void deleteLast() {

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        }
        
        Node prevNode = null;
        Node currentNode = null;
        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        count--;
        prevNode.next = null;
        lastNode = prevNode;
        
    }

    public void deleteNodeAtIndex(int index) {
        
    }
    
    public void deleteNode(Node node) {
        
    }
    
    public void deleteNode(int startIndex, int endIndex) {
        
    }
    
    // First Node
    public Node head() {
        return firstNode;
    }

    // Tail Node
    public Node tail() {
        return lastNode;
    }
    
    public int size() {
        return count;
    }
    
    public void print() {
        Node currentNode = firstNode;
        while (currentNode!=null) {
            
            System.out.print(currentNode.data);
            if (currentNode.next != null) {
                System.out.print("->");
            }
            
            currentNode = currentNode.next;
        }
    }
}

class NotEnoughNodesException extends Exception {

    String description() {
        return "Not enough nodes";
    }
}
