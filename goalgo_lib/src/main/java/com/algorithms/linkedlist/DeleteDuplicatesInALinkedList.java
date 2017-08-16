package com.algorithms.linkedlist;

import com.algorithms.Node;
import java.util.HashSet;

/**
 *
 * @author dsaha
 */
public class DeleteDuplicatesInALinkedList {

    private LinkedList linkedList = null;

    public DeleteDuplicatesInALinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public void deleteDuplicate() {
        HashSet<Integer> set = new HashSet<Integer>();
        Node iteratorNode = this.linkedList.head();
        Node previousNode = null;
        while (iteratorNode != null) {

            if (set.contains(iteratorNode.data)) {

                // Duplicate wasn't found
                previousNode.next = iteratorNode.next;

                // Store the node to be deleted
                Node deleteNode = iteratorNode;

                // Get pointer to the next pointer
                iteratorNode = iteratorNode.next;

                // Set the node to null
                deleteNode = null;
            } else {

                // Duplicate not found and is new data
                set.add((Integer) iteratorNode.data);

                previousNode = iteratorNode;
                iteratorNode = iteratorNode.next;
            }
        }
    }

    public static void driver() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);

        LinkedList ll = new LinkedList();
        ll.add(node1);
        ll.add(node2);
        ll.add(node3);
        
        DeleteDuplicatesInALinkedList driverObject = new DeleteDuplicatesInALinkedList(ll);
        System.out.println("Before");
        ll.print();
        driverObject.deleteDuplicate();
        System.out.println("\n\nAfter");
        ll.print();
    }

}
