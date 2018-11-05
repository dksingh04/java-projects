package com.dk.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	private T data;
	private List<Vertex<T>> neighbours = new ArrayList<>();
	private boolean visited;
	
	public Vertex(T data) {
		this.data = data;
	}
	
	public void addNeighbor(Vertex<T> node) {
		if(node!=null) {
			this.neighbours.add(node);
		}
		
	}
	public List<Vertex<T>> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<Vertex<T>> neighbours) {
		this.neighbours = neighbours;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}
