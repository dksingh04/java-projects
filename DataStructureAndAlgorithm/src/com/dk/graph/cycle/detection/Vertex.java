package com.dk.graph.cycle.detection;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	private T name;
	private boolean visited;
	private boolean beingVisited;
	private List<Vertex<T>> adjacenciList;
	
	public Vertex(T name) {
		this.name = name;
		this.adjacenciList = new ArrayList<>();
	}
	
	public void addAdjacencieNode(Vertex<T> node) {
		this.adjacenciList.add(node);
	}
	
	@Override
	public String toString() {
		return this.name.toString();
	}
	
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isBeingVisited() {
		return beingVisited;
	}
	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}
	public List<Vertex<T>> getAdjacenciList() {
		return adjacenciList;
	}
	public void setAdjacenciList(List<Vertex<T>> adjacenciList) {
		this.adjacenciList = adjacenciList;
	}
	
	
}
