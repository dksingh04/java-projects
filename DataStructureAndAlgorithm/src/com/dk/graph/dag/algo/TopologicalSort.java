package com.dk.graph.dag.algo;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	
	private Stack<Vertex> stack;
	
	public TopologicalSort() {
		this.stack = new Stack<>();
	}
	
	public void makeTopoLogicalOrdering(List<Vertex> vertexList) {
		for(Vertex v:vertexList) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
	}
	
	public void dfs(Vertex v) {
		v.setVisited(true);
		
		for(Edge e:v.getNeighbourList()) {
			
			if(!e.getTargetVertex().isVisited()) {	
				e.getTargetVertex().setVisited(true);
				dfs(e.getTargetVertex());
			}
		}
		
		this.stack.push(v);
	}
	
	public Stack<Vertex> getTopologicalOrder(){
		Collections.reverse(stack);
		return this.stack;
	}

}
