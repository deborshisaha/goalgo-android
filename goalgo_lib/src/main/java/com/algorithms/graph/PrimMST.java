package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrimMST {
    
    public ArrayList<Graph.Edge> apply(Graph g, Graph.Vertex<Integer> distanceFrom) {

        ArrayList<Graph.Edge> result = new ArrayList();
        
        // Initialize minHeap
        BinaryMinHeap<Graph.Vertex<Integer>> minHeap = new BinaryMinHeap<Graph.Vertex<Integer>>();

        // Path map
        Map<Graph.Vertex<Integer>, Graph.Edge> parentMap = new HashMap<Graph.Vertex<Integer>, Graph.Edge>();

        for (Graph.Vertex<Integer> v : g.getVertices()) {

            if (distanceFrom == v) {
                minHeap.add(0, v);
            } else {
                minHeap.add( Integer.MAX_VALUE, v);
            }
        }

        while (!minHeap.empty()) {
            
            // 1. Extract minimum from the heap
            Graph.Vertex<Integer> current = minHeap.extractMin();
            
            // 2. Add edges of the tree
            Graph.Edge STE = parentMap.get(current);
            if (STE!=null) {
                result.add(STE);
            }
            
            // 3. Start exploring children of the vertex that was just added
            for (Graph.Edge e : current.getEdges()) {

                // 3.a get vertext for an edge
                Graph.Vertex v = getVertexForEdge(current, e);

                // 3.b If we find an edge into a vertex with weight less than what 
                //     was previously explored, update minheap and parentMap
                if (minHeap.contains(v) && e.getWeight() < minHeap.getWeight(v)) {
                    minHeap.decrease(v, e.getWeight());
                    parentMap.put(v, e);
                }
            }
        }
        
        return result;
    }
    
    private Graph.Vertex getVertexForEdge(Graph.Vertex v, Graph.Edge e){
        return e.getDestination().equals(v) ? e.getDestination() : e.getSource();
    }
}
