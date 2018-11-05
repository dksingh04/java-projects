package com.dk.graph.dfs;

public class App {
	
	public static void main(String ...strings) {
		Vertex<String> root = new Vertex<String>("A");
		Vertex<String> b = new Vertex<String>("B");
		Vertex<String> c = new Vertex<String>("C");
		Vertex<String> d = new Vertex<String>("D");
		Vertex<String> e = new Vertex<String>("E");
		Vertex<String> f = new Vertex<String>("F");
		Vertex<String> g = new Vertex<String>("G");
		Vertex<String> h = new Vertex<String>("H");
		Vertex<String> i = new Vertex<String>("I");
		
		root.addNeighbor(b);
		root.addNeighbor(c);
		
		b.addNeighbor(d);
		b.addNeighbor(f);
		
		c.addNeighbor(g);
		c.addNeighbor(h);
		
		g.addNeighbor(i);
		
		DFSearch<String> dfs = new DFSearch<>();
		dfs.dfs(root);
	}

}
