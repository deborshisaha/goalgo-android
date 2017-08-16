/*
 * Given a linklist and k,reverse alternate k nodes in the linklist.
 */
package com.algorithms.linkedlist;

import com.algorithms.Node;

/**
 *
 * @author dsaha
 */
public class ReverseAlternateKNodes {

    private LinkedList ll = null;

    public ReverseAlternateKNodes(LinkedList ll) {
        this.ll = ll;
    }

    public void reverse(int frequency) {

        if (this.ll.size() < frequency) {
            return;
        }

        Node startItemOfSkip = this.ll.head();
        Node lastItemOfSkip = null;
        while (true) {
            try {
                // Skip straight
                lastItemOfSkip = skip(startItemOfSkip, frequency);

                // reverse
                if (lastItemOfSkip == null) {
                    break;
                }
                
                Node reversedHeadNode = reverse(lastItemOfSkip.next, frequency);
                lastItemOfSkip.next = reversedHeadNode;
                
                // skip reverse
                startItemOfSkip = skip(reversedHeadNode, frequency).next;

            } catch (NotEnoughNodesException e) {
                // Ignore
                break;
            }
        }

    }

    // Returns last element of the skipped chain list
    private Node skip(Node node, int skipTo) throws NotEnoughNodesException {
        
        if (node == null) {
            throw new NotEnoughNodesException();
        }
       
        Node iterationNode = node;
        int skipCount = 1;
        while (skipCount != skipTo) {
            iterationNode = iterationNode.next;
            skipCount++;
        }

        if (skipCount != skipTo) {
            throw new NotEnoughNodesException();
        }

        return iterationNode;
    }

    private Node reverse(Node node, int reverseBy) throws NotEnoughNodesException {

        if (node == null) {
            return null;
        }

        Node currentNode = node;
        Node nextNode = node.next;
        Node reversedNextNode = null;
        
        int reverseCount = 1;

        while (reverseCount != reverseBy) {

            currentNode.next = reversedNextNode;
            reversedNextNode = currentNode;
            currentNode = nextNode;
            
            if (currentNode!= null) {
                nextNode = currentNode.next;
                currentNode.next = reversedNextNode;
                reverseCount++;
            }
            
            
        }
        node.next = nextNode;
       
        if (reverseCount != reverseBy) {
            throw new NotEnoughNodesException();
        }
        
        return currentNode;
    }

    public static void driver() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        
        LinkedList ll = new LinkedList();
        ll.add(node1);
        ll.add(node2);
        ll.add(node3);
        ll.add(node4);
        ll.add(node5);
        ll.add(node6);
        ll.add(node7);
        ll.add(node8);

        ReverseAlternateKNodes driverObject = new ReverseAlternateKNodes(ll);
        System.out.println();
        System.out.println("Before");
        ll.print();
        System.out.println();
        
        driverObject.reverse(4);

        System.out.println("After");
        ll.print();
        System.out.println();
    }
}
