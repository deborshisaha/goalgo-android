package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public TopologicalSort(Graph g) {
        this.graph = g;
    }

    private Graph graph;
    private Set<Graph.Vertex> visitedSet = new HashSet<Graph.Vertex>();
    private Stack<Graph.Vertex> stack = new Stack<Graph.Vertex>();

    private Graph.Vertex<String> getStartVertex() {
        for (Graph.Vertex<String> v : this.graph.getVertices()) {
            if (!this.visitedSet.contains(v)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<String> getOrder() {
        Graph.Vertex sv = getStartVertex();
        while (sv != null) {
            if (explore(sv)) {
                sv = getStartVertex();
            }
        }

        ArrayList<String> list = new ArrayList<String>();

        while (!this.stack.empty()) {
            Graph.Vertex vi = this.stack.pop();
            list.add(vi.getIdentifier());
            //System.out.print(vi.getIdentifier());
            
        }

        return list;
    }

    private boolean explore(Graph.Vertex<String> v) {

        boolean allChildVisited = true;

        this.visitedSet.add(v);

        for (Graph.Vertex<String> cv : v.getChildren()) {
            if (!this.visitedSet.contains(cv)) {
                allChildVisited = explore(cv);
            }
        }

        if (allChildVisited) {
            stack.push(v);
        }

        return allChildVisited;
    }
    
    public static void driver() {
        GraphSetting gs = new GraphSetting();
        gs.setDirected(true);
        
        Graph g = new Graph(gs);
        
        g.addEdge("A", "B",0);
        g.addEdge("B", "C",0);
        g.addEdge("B", "E",0);
        g.addEdge("C", "D",0);
        g.addEdge("E", "F",0);
        g.addEdge("D", "F",0);
        g.addEdge("F", "G",0);
        
        TopologicalSort tp = new TopologicalSort(g);
        
        for (String s: tp.getOrder()) {
            System.out.print(s+"->");
        }
    }
}
