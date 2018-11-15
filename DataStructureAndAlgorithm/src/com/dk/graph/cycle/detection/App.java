package com.dk.graph.cycle.detection;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String ...strings){
		
		Vertex<String> v1 = new Vertex<>("1");
		Vertex<String> v2 = new Vertex<>("2");
		Vertex<String> v3 = new Vertex<>("3");
		Vertex<String> v4 = new Vertex<>("4");
		Vertex<String> v5 = new Vertex<>("5");
		Vertex<String> v6 = new Vertex<>("6");
		
		// One cycle in the graph
		
		v1.addAdjacencieNode(v2);
		v1.addAdjacencieNode(v3);
		v2.addAdjacencieNode(v3);
		
		v4.addAdjacencieNode(v1);
		v4.addAdjacencieNode(v5);
		
		v5.addAdjacencieNode(v6);
		v6.addAdjacencieNode(v4);
		
		List<Vertex<String>> graph = new ArrayList<>();
		
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);
		graph.add(v6);
		
		CyclicDetection<String> cycleDetectionGraph = new CyclicDetection<>();
		
		cycleDetectionGraph.detectGraphCycling(graph);
		
		// Adding two cycle in the graph.
		Vertex<String> v01 = new Vertex<>("01");
		Vertex<String> v02 = new Vertex<>("02");
		Vertex<String> v03 = new Vertex<>("03");
		Vertex<String> v04 = new Vertex<>("04");
		Vertex<String> v05 = new Vertex<>("05");
		Vertex<String> v06 = new Vertex<>("06");
		
		v01.addAdjacencieNode(v02);
		v02.addAdjacencieNode(v03);
		v03.addAdjacencieNode(v01);
		
		v04.addAdjacencieNode(v01);
		v04.addAdjacencieNode(v05);
		
		v05.addAdjacencieNode(v06);
		v06.addAdjacencieNode(v04);
		
		List<Vertex<String>> graph2 = new ArrayList<>();
		
		graph2.add(v01);
		graph2.add(v02);
		graph2.add(v03);
		graph2.add(v04);
		graph2.add(v05);
		graph2.add(v06);
		
		cycleDetectionGraph.detectGraphCycling(graph2);
		
	}

}
