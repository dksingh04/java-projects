package com.dk.graph.cycle.detection;

import java.util.List;

public class CyclicDetection<T> {
	
	public void detectGraphCycling(List<Vertex<T>> graph) {
		
		for(Vertex<T> v: graph) {
			if(!v.isVisited()) {
				dfsCyclingCheck(v);
			}
			
		}
		
	}
	
	public void dfsCyclingCheck(Vertex<T> vertex) {
		
		vertex.setBeingVisited(true);
		System.out.println("Visiting Being Vertex: "+vertex);
		
		for(Vertex<T> node: vertex.getAdjacenciList()) {
			System.out.println("Visiting child node "+node+" of Vertex "+vertex);
			if(node.isBeingVisited()) {
				System.out.println("Node "+node+" is already being visited of "+ vertex+", hence there is cycle in the graph");
				return;
			}
			if(!node.isVisited()) {
				node.setVisited(true);
				System.out.println("Visiting Vertex :"+node+" recursivily.");
				dfsCyclingCheck(node);
			}
			
		}
		
		System.out.println("Setting Being Visited to false and Visited to true for Vertex "+vertex);
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
		
	}

}
