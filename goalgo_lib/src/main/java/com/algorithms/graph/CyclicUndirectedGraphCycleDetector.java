/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.graph;

/**
 *
 * @author dsaha
 */
public class CyclicUndirectedGraphCycleDetector {

    private Graph g;

    public CyclicUndirectedGraphCycleDetector(Graph g) {
        this.g = g;
    }

    public boolean isCyclePresent() {

        DisjointSet<Graph.Vertex<String>> disjoinSet = new DisjointSet<Graph.Vertex<String>>();

        for (Graph.Vertex v : this.g.getVertices()) {
            disjoinSet.makeSet(v);
        }

        for (Graph.Edge e : this.g.getEdges()) {
            if (disjoinSet.union(e.getSource(), e.getDestination())) {
                return true;
            }
        }

        return false;
    }

    public static void driver() {
        GraphSetting setting = new GraphSetting();
        setting.setDirected(false);

        Graph graph = new Graph(setting);

        graph.addEdge("A", "B", 0);
        graph.addEdge("B", "C", 0);
        //graph.addEdge("C", "A", 0);
        graph.addEdge("C", "D", 0);
        //graph.addEdge("D", "E", 0);
        graph.addEdge("E", "A", 0);
        
        CyclicUndirectedGraphCycleDetector detector = new CyclicUndirectedGraphCycleDetector(graph);
        System.out.println("cycle present: " + detector.isCyclePresent());
    }
}
