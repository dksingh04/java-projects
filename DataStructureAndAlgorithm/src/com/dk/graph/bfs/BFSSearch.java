package com.dk.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSearch<T> {
	
	public void bfs(Vertex<T> root){
		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.add(root);
		root.setVisited(true);
		while(!queue.isEmpty()){
			Vertex<T> next = queue.poll();
			System.out.print(next.getData()+" ");
			for(Vertex<T> vNode: next.getChildrens()){
				if(!vNode.isVisited()){
					vNode.setVisited(true);
					queue.add(vNode);
				}
			}
		}
	}

	public static void main(String ...args){
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Vertex<Integer> v3 = new Vertex<>(3);
		Vertex<Integer> v4 = new Vertex<>(4);
		Vertex<Integer> v5 = new Vertex<>(5);
		Vertex<Integer> v6 = new Vertex<>(6);
		Vertex<Integer> v7 = new Vertex<>(7);
		Vertex<Integer> v8 = new Vertex<>(8);
		
		v1.addChild(v2);
		v1.addChild(v3);
		v1.addChild(v4);
		
		v2.addChild(v5);
		v3.addChild(v6);
		v3.addChild(v7);
		v5.addChild(v8);
		BFSSearch<Integer> bfsSearch = new BFSSearch<>();
		bfsSearch.bfs(v1);
	}
}
