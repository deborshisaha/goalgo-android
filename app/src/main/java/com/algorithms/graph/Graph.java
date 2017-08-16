package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    // All vertices
    private HashMap<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    // All edges
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    private GraphSetting settings;

    public Graph() {
    }

    public Graph(GraphSetting settings) {
        this.settings = settings;
    }

    public void addEdge(String sIdentifier, String dIdentifier, Integer weight) {

        Vertex vs = null;
        Vertex vd = null;

        // Look up edge in the map
        if (this.vertexMap.containsKey(sIdentifier)) {
            vs = this.vertexMap.get(sIdentifier);
        } else {
            vs = new Vertex(sIdentifier);
            this.vertexMap.put(vs.getIdentifier(), vs);
        }

        // Look up edge in the map
        if (this.vertexMap.containsKey(dIdentifier)) {
            vd = this.vertexMap.get(dIdentifier);
        } else {
            vd = new Vertex(dIdentifier);
            this.vertexMap.put(vd.getIdentifier(), vd);
        }

        Edge e = new Edge(vs, vd, this.settings.isDirected(), weight);
        this.edges.add(e);

        vs.addAdjacentVertex(e, vd);
        vd.addAdjacentVertex(e, vs);
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public ArrayList<Vertex> getVertices() {
        ArrayList<Vertex> vertices = new ArrayList<Vertex>(this.vertexMap.values());
        return vertices;
    }

    public static void driver() {
        GraphSetting setting = new GraphSetting();
        setting.setDirected(true);

        Graph graph = new Graph(setting);
        graph.addEdge("A", "B", 0);
    }

    class Vertex<T> {

        public T data;

        private List<Edge> edges = new ArrayList<>();

        // identifier
        private String identifier;

        // Children or Outgoing Edges
        private ArrayList<Vertex> children = new ArrayList<Vertex>();

        public String getIdentifier() {
            return this.identifier;
        }

        public ArrayList<Vertex> getChildren() {
            return this.children;
        }

        public Vertex(String identifier) {
            this.identifier = identifier;
        }

        public void addAdjacentVertex(Edge e, Vertex child) {
            this.children.add(child);
            this.edges.add(e);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.identifier.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Vertex other = (Vertex) obj;
            if (this.getIdentifier() != other.getIdentifier()) {
                return false;
            }
            return true;
        }

        Iterable<Graph.Edge> getEdges() {
            return this.edges;
        }
    }

    public class Edge {

        private Vertex source;
        private Vertex destination;
        private Integer weight;

        public Edge() {
        }

        public Edge(Vertex source, Vertex destination, boolean directed, Integer weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;

            this.source.addAdjacentVertex(this, destination);

            if (directed) {
                this.destination.addAdjacentVertex(this, source);
            }
        }

        public Edge(Vertex source, Vertex destination, boolean directed) {
            this.source = source;
            this.destination = destination;
            this.weight = 0;

            this.source.addAdjacentVertex(this, destination);

            if (directed) {
                this.destination.addAdjacentVertex(this, source);
            }
        }

        public Edge(Vertex source, Vertex destination) {
            this.source = source;
            this.destination = destination;
        }

        public Vertex getSource() {
            return this.source;
        }

        public Vertex getDestination() {
            return this.destination;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((this.source == null) ? 0 : this.source.hashCode());
            result = prime * result + ((this.destination == null) ? 0 : this.destination.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Edge other = (Edge) obj;
            if (this.source == null) {
                if (other.source != null) {
                    return false;
                }
            } else if (!this.source.equals(other.source)) {
                return false;
            }
            if (this.destination == null) {
                if (other.destination != null) {
                    return false;
                }
            } else if (!this.destination.equals(other.destination)) {
                return false;
            }
            return true;
        }

        Integer getWeight() {
            return this.weight;
        }
    }
}

class GraphSetting {

    private boolean directed = false;

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public boolean isDirected() {
        return this.directed;
    }
}

//class Edge {
//
//    private Vertex source;
//    private Vertex destination;
//    private Integer weight;
//    public Edge() {
//    }
//
//    public Edge(Vertex source, Vertex destination, boolean directed, Integer weight) {
//        this.source = source;
//        this.destination = destination;
//        this.weight = weight;
//        
//        this.source.addAdjacentVertex(this, destination);
//
//        if (directed) {
//            this.destination.addAdjacentVertex(this, source);
//        }
//    }
//
//    public Edge(Vertex source, Vertex destination, boolean directed) {
//        this.source = source;
//        this.destination = destination;
//        this.weight = 0;
//        
//        this.source.addAdjacentVertex(this, destination);
//
//        if (directed) {
//            this.destination.addAdjacentVertex(this, source);
//        }
//    }
//
//    public Edge(Vertex source, Vertex destination) {
//        this.source = source;
//        this.destination = destination;
//    }
//        
//    public Vertex getSource() {
//        return this.source;
//    }
//
//    public Vertex getDestination() {
//        return this.destination;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((this.source == null) ? 0 : this.source.hashCode());
//        result = prime * result + ((this.destination == null) ? 0 : this.destination.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        Edge other = (Edge) obj;
//        if (this.source == null) {
//            if (other.source != null) {
//                return false;
//            }
//        } else if (!this.source.equals(other.source)) {
//            return false;
//        }
//        if (this.destination == null) {
//            if (other.destination != null) {
//                return false;
//            }
//        } else if (!this.destination.equals(other.destination)) {
//            return false;
//        }
//        return true;
//    }
//
//    Integer getWeight() {
//        return this.weight;
//    }
//}
