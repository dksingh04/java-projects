package com.dk.graph.dag.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {
	
	public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex) {
		sourceVertex.setDistance(0);
		TopologicalSort topological = new TopologicalSort();
		topological.makeTopoLogicalOrdering(vertexList);
		Stack<Vertex> stack = topological.getTopologicalOrder();
		
		for(Vertex vertex:stack) {
			
			for(Edge edge:vertex.getNeighbourList()) {
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();
				
				double newDistance = u.getDistance()+edge.getWeight();
				if(newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPreviousVertex(u);
				}
			}
		}
		
		if(targetVertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("No Shortest Path is there ...");
		}else {
			System.out.println("Shortest Path to target Vertex : "+targetVertex.getDistance());
		}
		
	}
	
	public List<Vertex> showShortestPathTo(Vertex targetVertex) {
		List<Vertex> vertexList = new ArrayList<>();
		Vertex actualVertex = targetVertex;
		vertexList.add(actualVertex);
		
		while(actualVertex.getPreviousVertex()!=null) {
			actualVertex = actualVertex.getPreviousVertex();
			vertexList.add(actualVertex);
			
		}
		Collections.reverse(vertexList);
		
		return vertexList;
	}

}
