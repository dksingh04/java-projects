package com.dk.graph.dfs;

import java.util.Stack;

public class DFSearch<T> {
	
	public void dfs(Vertex<T> root) {
		
		Stack<Vertex<T>> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Vertex<T> v = stack.pop();
			System.out.println("Data: "+v.getData());
			for(Vertex<T> elem:v.getNeighbours()) {
				if(!elem.isVisited()) {
					stack.push(elem);
					elem.setVisited(true);
				}
			}
		}
	}

}
