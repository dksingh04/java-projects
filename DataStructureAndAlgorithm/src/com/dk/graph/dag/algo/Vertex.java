package com.dk.graph.dag.algo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private String name;
	private boolean visited;
	private Vertex previousVertex;
	private List<Edge> neighbourList;
	private double distance = Double.MAX_VALUE;
	
	public Vertex(String name) {
		this.name = name;
		this.neighbourList = new ArrayList<>();
	}
	
	public void addNeighbour(Edge e) {
		this.neighbourList.add(e);
	}
	@Override
	public String toString() {
		return this.name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getNeighbourList() {
		return neighbourList;
	}

	public void setNeighbourList(List<Edge> neighbourList) {
		this.neighbourList = neighbourList;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	

}
