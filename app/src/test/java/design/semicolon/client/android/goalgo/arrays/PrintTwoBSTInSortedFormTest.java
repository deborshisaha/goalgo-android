package design.semicolon.client.android.goalgo.arrays;

import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.PrintTwoBSTInSortedForm;

import org.junit.Test;

public class PrintTwoBSTInSortedFormTest {

    @Test
    public void basic_test() throws Exception {
        BinarySearchTree bst1 = new BinarySearchTree();
        BinarySearchTree bst2 = new BinarySearchTree();

        bst1.insert(10);
        bst1.insert(15);
        bst1.insert(5);
        bst1.insert(7);
        bst1.insert(19);
        bst1.insert(20);
        bst1.insert(-1);

        bst2.insert(-4);
        bst2.insert(-3);
        bst2.insert(6);
        bst2.insert(11);
        bst2.insert(22);
        bst2.insert(26);

        PrintTwoBSTInSortedForm printer = new PrintTwoBSTInSortedForm();
        printer.print(bst1, bst2);
    }
}
