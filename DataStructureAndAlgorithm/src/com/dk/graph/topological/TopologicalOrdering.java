package com.dk.graph.topological;

import java.util.Stack;

public class TopologicalOrdering<T> {
	Stack<Vertex<T>> stack;
	
	public TopologicalOrdering() {
		stack = new Stack<Vertex<T>>();
	}
	
	public void dfs(Vertex<T> vertex) {
		vertex.setVisited(true);
		
		for(Vertex<T> v : vertex.getNeighbours()) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
		
		stack.push(vertex);
	}
	
	public Stack<Vertex<T>> getVisitedGraphs(){
		return this.stack;
	}
	
}
