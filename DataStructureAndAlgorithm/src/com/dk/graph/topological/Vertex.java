package com.dk.graph.topological;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	private T data;
	private List<Vertex<T>> neighbours;
	boolean visited;
	
	public T getData() {
		return data;
	}
	
	public Vertex(T data) {
		this.data = data;
		this.neighbours = new ArrayList<>();
	}
	
	public boolean addNeighbour(Vertex<T> v) {
		this.neighbours.add(v);
		return true;
		
	}
	
	@Override
	public String toString() {
		
		return this.data.toString();
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<Vertex<T>> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<Vertex<T>> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}
