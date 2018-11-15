package com.dk.graph.topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
	
	public static void main(String ...strings) {
		TopologicalOrdering<String> tp = new TopologicalOrdering<>();
		
		Vertex<String> v0 = new Vertex<>("1");
		Vertex<String> v1 = new Vertex<>("2");
		Vertex<String> v2 = new Vertex<>("3");
		Vertex<String> v3 = new Vertex<>("4");
		Vertex<String> v4 = new Vertex<>("5");
		Vertex<String> v5 = new Vertex<>("6");
		Vertex<String> v6 = new Vertex<>("7");
		
		v0.addNeighbour(v3);
		v0.addNeighbour(v4);
		
		v1.addNeighbour(v2);
		v1.addNeighbour(v5);
		
		v3.addNeighbour(v1);
		
		v2.addNeighbour(v6);
		
		List<Vertex<String>> graph =  new ArrayList<>();
		
		graph.add(v0);
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);
		graph.add(v6);
		
		for(Vertex<String> v: graph) {
			if(!v.isVisited()) {
				tp.dfs(v);
			}
		}
		
		Stack<Vertex<String>> stack = tp.getVisitedGraphs();
		
		for(Vertex<String> v: stack) {
			System.out.print(v + " - ");
		}
		//v5.addNeighbour(v)
	}

}
