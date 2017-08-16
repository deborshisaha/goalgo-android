package com.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    // Works on directed and undirected graph weight > 0
    // Greedy
    // Need a data structure 
    // decrease, extractMin, contains  and add --- Each operation is O(log n)
    public Map<Graph.Vertex<Integer>, Integer> apply(Graph g, Graph.Vertex<Integer> distanceFrom) {

        // Initialize minHeap
        BinaryMinHeap<Graph.Vertex<Integer>> minHeap = new BinaryMinHeap<Graph.Vertex<Integer>>();

        // distance map
        Map<Graph.Vertex<Integer>, Integer> distanceMap = new HashMap<Graph.Vertex<Integer>, Integer>();

        // Path map
        Map<Graph.Vertex<Integer>, Graph.Vertex<Integer>> parentMap = new HashMap<Graph.Vertex<Integer>, Graph.Vertex<Integer>>();

        for (Graph.Vertex v : g.getVertices()) {

            if (distanceFrom == v) {
                minHeap.add(0, v);
            } else {
                minHeap.add( Integer.MAX_VALUE, v);
            }
        }

        while (!minHeap.empty()) {
            
            // 1. Extract minimum from the heap
            BinaryMinHeap<Graph.Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
            Graph.Vertex<Integer> current = heapNode.key;

            // 2. Add to Distance Map
            distanceMap.put(current, heapNode.weight);

            // 3. Start exploring children of the vertex that was just added
            for (Graph.Edge e : current.getEdges()) {

                // 3.a Get adjacent vertex
                Graph.Vertex v = getVertexForEdge(current, e);

                // 3.b If the vertex is in the minHeap then process otherwise it has already been processed
                if (!minHeap.contains(v)) {
                    // continue
                    continue;
                }
                
                // 3.c Update the distance map if cost found is less than what was previous computed
                Integer newDistance = distanceMap.get(v) + e.getWeight();
                Integer distance = minHeap.getWeight(v);

                if (distance > newDistance) {
                    minHeap.decrease(v, newDistance);
                    parentMap.put(v, current);
                }
            }
        }
        
        return distanceMap;
    }

    private Graph.Vertex getVertexForEdge(Graph.Vertex<Integer> v, Graph.Edge e) {
        return e.getSource().equals(v) ? e.getDestination() : e.getSource();
    }

}
