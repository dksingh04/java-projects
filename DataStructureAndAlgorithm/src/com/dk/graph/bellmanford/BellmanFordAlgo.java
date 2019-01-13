package com.dk.graph.bellmanford;

import java.util.List;

public class BellmanFordAlgo {
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	
	public BellmanFordAlgo(List<Vertex> vertexList, List<Edge> edgeList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public void computePaths(Vertex sourceVertex) {
		sourceVertex.setDistance(0);
		for(int i = 0; i < vertexList.size()-1; i++) {
			
			for(Edge edge:edgeList) {
				
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();
				
				if(u.getDistance() == Double.MAX_VALUE) {
					continue;
				}
				double newDistance = u.getDistance()+edge.getWeight();
				if(newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPreviousVertex(u);
				}
			}
		}
		
		//Detect negative cycle
		for(Edge edge:edgeList) {
			if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
				if(hashCycle(edge)) {
					System.out.println("There has been a Negative cycle in the graph");
					return;
				}
			}
		}
	}
	
	public boolean hashCycle(Edge e) {
		return e.getStartVertex().getDistance()+e.getWeight() < e.getTargetVertex().getDistance();
	}
	
	public void shortestPathTo(Vertex targetVertex) {
		if(targetVertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("There is no Path exist to target path "+targetVertex+" ....");
		}
		Vertex actualVertex = targetVertex;
		while(actualVertex!=null) {
			System.out.print(actualVertex + " - ");
			actualVertex = actualVertex.getPreviousVertex();
		}
	}

}
