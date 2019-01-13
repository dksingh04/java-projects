package com.dk.graph.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
	public void computePaths(Vertex sourceVertex) {
		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		sourceVertex.setVisited(true);
		pQueue.add(sourceVertex);
		
		while(!pQueue.isEmpty()) {
			Vertex actualVertex = pQueue.poll();
			for(Edge e : actualVertex.getAdjacenciesList()) {
				Vertex targetVertex = e.getTargetVertex();
				double newDistance = actualVertex.getDistance() + e.getWeight();
				if(newDistance < targetVertex.getDistance()) {
					pQueue.remove(targetVertex);
					targetVertex.setDistance(newDistance);
					targetVertex.setPredecessor(actualVertex);
					pQueue.add(targetVertex);
				}
						
			}
		}
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex){
		
		List<Vertex> pathList = new ArrayList<>();
		for(Vertex v =  targetVertex; v!=null; v = v.getPredecessor()) {
			pathList.add(v);
		}
		
		Collections.sort(pathList);
		
		return pathList;
	}

}
