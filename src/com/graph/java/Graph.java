package com.graph.java;

import com.utilities.java.Edge;
import com.utilities.java.Vertex;

import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    public ArrayList<Vertex> childrenOf(Vertex vertex) {
        return adjacencyList.get(vertex);
    }

    public boolean hasNode(Vertex vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public Vertex getNode(String name) {
        for (Vertex vertex : adjacencyList.keySet()) {
            if (vertex.equals(name)) {
                return vertex;
            }
        }
        return null;
    }

    public ArrayList<Vertex> BFS(Vertex start, Vertex end) {
        ArrayList<Vertex> initialPath = new ArrayList<>();
        initialPath.add(start);
        Queue<ArrayList<Vertex>> pathQueue = new LinkedList<>();
        ArrayList<Vertex> tempPath;
        pathQueue.add(initialPath);
        while (!pathQueue.isEmpty()) {
            tempPath = pathQueue.remove();
            Vertex lastVertex = tempPath.get(tempPath.size() - 1);
            if (lastVertex.equals(end)) {
                return tempPath;
            }
            for (Vertex nextVertex : childrenOf(lastVertex)) {
                if (!tempPath.contains(nextVertex)) {
                    ArrayList<Vertex> newPath = new ArrayList<>();
                    for (Vertex vertex : tempPath) {
                        newPath.add(vertex);
                    }
                    newPath.add(nextVertex);
                    pathQueue.add(newPath);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Vertex vertex6 = new Vertex("F");
        Vertex vertex7 = new Vertex("G");
        Vertex vertex8 = new Vertex("I");
        Vertex vertex9 = new Vertex("J");
        Vertex vertex10 = new Vertex("K");
        Edge edge1 = new Edge(vertex1, vertex2);
        Edge edge2 = new Edge(vertex1, vertex3);
        Edge edge3 = new Edge(vertex1, vertex4);
        Edge edge4 = new Edge(vertex2, vertex5);
        Edge edge5 = new Edge(vertex3, vertex6);
        Edge edge6 = new Edge(vertex4, vertex7);
        Edge edge7 = new Edge(vertex7, vertex8);
        Edge edge8 = new Edge(vertex7, vertex9);
        Edge edge9 = new Edge(vertex9, vertex10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        graph.addEdge(edge4);
        graph.addEdge(edge5);
        graph.addEdge(edge6);
        graph.addEdge(edge7);
        graph.addEdge(edge8);
        graph.addEdge(edge9);
        ArrayList<Vertex> path = graph.BFS(vertex1, vertex5);
        for (Vertex vertex : path) {
            System.out.print(vertex.getName() + " ");
        }
    }
}