package com.algorithms.linkedlist;

import com.algorithms.Node;

public class DeleteNAfterMNodes {

    private Node linkedList = null;

    public DeleteNAfterMNodes(Node linkedList) {
        this.linkedList = linkedList;
    }

    public void delete(int after, int howMany) throws NotEnoughNodesException {

        Node iteratorNode = this.linkedList;

        int skipCount = 0;

        while (iteratorNode != null && skipCount!= after) {
            if (skipCount == after - 1) {
                // Start deleting
                int deleteCount = 0;
                Node deleteNode = iteratorNode.next;
                Node prevDeleteNode = deleteNode;

                while (deleteCount != howMany && deleteNode!= null) {
                    prevDeleteNode = deleteNode;
                    deleteNode = deleteNode.next;
                    prevDeleteNode = null;
                    deleteCount++;
                }
                
                if (deleteCount != howMany) {
                    throw new NotEnoughNodesException();
                } else {
                    iteratorNode.next = deleteNode;
                    break;
                }
            }

            skipCount++;
        }

        if (skipCount < after - 1) {
            throw new NotEnoughNodesException();
        }
    }

    public static void driver() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        LinkedList ll = new LinkedList();
        ll.add(node1);
        ll.add(node2);
        ll.add(node3);
        ll.add(node4);
        
        DeleteNAfterMNodes driverObject = new DeleteNAfterMNodes(node1);
        System.out.println("Before");
        ll.print();
        
        try {
            driverObject.delete(1, 2);
        } catch (NotEnoughNodesException e) {
            System.out.println(e.description());
        }
        System.out.println("After");
        ll.print();
    }

}
