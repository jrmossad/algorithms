package com.graph.java;

import com.utilities.java.Edge;
import com.utilities.java.Vertex;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<Vertex, ArrayList<Vertex>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String name) {
        Vertex newVertex = new Vertex(name);
        if (adjacencyList.containsKey(newVertex)) {
            System.out.println("Duplicate Vertex");
        } else {
            adjacencyList.put(newVertex, new ArrayList<>());
        }
    }

    public void addEdge(Edge edge) {
        Vertex source = edge.getSource();
        Vertex destination = edge.getDestination();
        if (!(adjacencyList.containsKey(source) && adjacencyList.containsKey(destination))) {
            System.out.println("One of the vertices is not on the graph");
            return;
        }
        adjacencyList.get(source).add(destination);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Edge edge1 = new Edge(vertex1, vertex2);
        Edge edge2 = new Edge(vertex1, vertex3);
        graph.addVertex("A");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(edge1);
        graph.addEdge(edge2);

    }
}