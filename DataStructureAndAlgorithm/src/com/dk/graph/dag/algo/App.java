package com.dk.graph.dag.algo;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		
		vertexList.add(v0);
		vertexList.add(v1);
		vertexList.add(v2);
		
		v0.addNeighbour(new Edge(1, v0, v1));
		v0.addNeighbour(new Edge(3, v0, v2));
		v1.addNeighbour(new Edge(1, v1, v2));
		
		AcyclicShortestPath algo = new AcyclicShortestPath();
		
		algo.shortestPath(vertexList, v0, v2);
		System.out.println(algo.showShortestPathTo(v2));
		
	}

}
