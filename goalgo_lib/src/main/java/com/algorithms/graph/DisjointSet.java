package com.algorithms.graph;

import com.algorithms.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class DisjointSet<T> {
    
    private Map<T,TreeNode> map = new HashMap<>();
    
    // makeSet
    public void makeSet(T data) {
        TreeNode<T> node = new TreeNode<>(data);
        node.setParent(node);
        node.setRank(0);
        map.put(data, node);
    }
    
    // Union
    // returns true if data are in same set or false if data are in different set
    public boolean union(T a, T b) {
        
        TreeNode<T> one = map.get(a);
        TreeNode<T> two = map.get(b);
        
        // Find the set to which they belong and then make union
        TreeNode<T> parentOne = findSet(a);
        TreeNode<T> parentTwo = findSet(b);
        
        if (parentOne.data == parentTwo.data) {
            return true;
        }
        
        if (parentTwo.getRank() > parentOne.getRank()) {
            parentOne.setParent(parentTwo);
        } else {
            parentTwo.setParent(parentOne);
            parentOne.setRank(((parentOne.getRank() == parentTwo.getRank())?(parentOne.getRank()+1):parentOne.getRank()));
        }
        
        return false;
    }
    
    // findSet
    public TreeNode<T> findSet(T a) {
        TreeNode<T> one = map.get(a);
        TreeNode<T> node = one.getParent();
        while (node!= node.getParent()) {
            node = node.getParent();
        }
        
        one.setParent(node);// = node;
        return one.getParent();
    }
    
    public static void driver() {
        DisjointSet<Integer> ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(2).data);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(4).data);
        System.out.println(ds.findSet(5).data);
        System.out.println(ds.findSet(6).data);
        System.out.println(ds.findSet(7).data);
    }
}
