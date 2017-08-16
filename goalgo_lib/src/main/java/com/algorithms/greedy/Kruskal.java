package com.algorithms.greedy;

import com.algorithms.TreeNode;
import com.algorithms.graph.DisjointSet;
import com.algorithms.graph.Graph;
import java.util.ArrayList;

public class Kruskal {

    private Graph g = null;

    public Kruskal(Graph g) {
        this.g = g;
    }

    public static void driver() {
        Graph g = new Graph();
        Kruskal obj = new Kruskal(g);
        System.out.print(obj.getMST());
    }

    private ArrayList<Graph.Edge> getMST() {
        
        ArrayList<Graph.Edge> result = new ArrayList();
        
        DisjointSet<Integer> ds = new DisjointSet<Integer>();
        
        
        return result;
    }

}
