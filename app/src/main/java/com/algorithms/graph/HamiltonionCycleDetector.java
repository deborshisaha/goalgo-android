package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HamiltonionCycleDetector {

    private Graph g;
    private Set<Graph.Vertex<Integer>> visitedSet = new HashSet<Graph.Vertex<Integer>>();
    private List<Graph.Vertex<Integer>> result = new ArrayList<Graph.Vertex<Integer>>();

    private Graph.Vertex startVertex = null;

    public HamiltonionCycleDetector(Graph g) {
        this.g = g;
    }

    public boolean isHamlitonian(Graph g) {
        this.startVertex = g.getVertices().iterator().next();
        return isHamlitonianUtil(this.startVertex);
    }

    private boolean isHamlitonianUtil(Graph.Vertex<Integer> currentVertex) {

        this.visitedSet.add(currentVertex);
        this.result.add(currentVertex);

        for (Graph.Vertex<Integer> childV : currentVertex.getChildren()) {

            if (this.startVertex == childV && this.result.size() == this.g.getVertices().size()) {
                return true;
            }

            if (!this.visitedSet.contains(childV)) {
                boolean isHamiltonionCycyle = isHamlitonianUtil(childV);
                if (isHamiltonionCycyle) {
                    return true;
                }
            }
        }

        this.visitedSet.remove(currentVertex);
        this.result.remove(currentVertex);

        return false;
    }

}
