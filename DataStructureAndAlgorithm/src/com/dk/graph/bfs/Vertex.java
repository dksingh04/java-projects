package com.dk.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	private T data;
	private List<Vertex<T>> childrens;
	private boolean isVisited;
	
	public Vertex(T data){
		this.data=data;
		this.childrens = new ArrayList<>();
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public List<Vertex<T>> getChildrens() {
		return childrens;
	}

	public T getData() {
		return data;
	}

	public void addChild(Vertex<T> v){
		if(v!=null){
			this.childrens.add(v);
		}
		
	}
	
	
}
