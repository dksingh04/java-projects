package com.dk.graph.dijkstra;

import java.util.List;
import java.util.function.Consumer;

public class App {
	
	public static void main(String ...strings) {
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		
		v0.addNeighbour(new Edge(1, v0, v1));
		v0.addNeighbour(new Edge(3, v0, v2));
		v1.addNeighbour(new Edge(1, v1, v2));
		DijkstraAlgorithm algo = new DijkstraAlgorithm();
		algo.computePaths(v0);		
		Consumer<List<Vertex>> c = System.out::println;
		
		c.accept(algo.getShortestPathTo(v2));
	}
}
