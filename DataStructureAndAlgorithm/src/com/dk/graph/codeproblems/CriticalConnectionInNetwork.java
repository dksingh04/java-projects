package com.dk.graph.codeproblems;

import java.util.*;

public class CriticalConnectionInNetwork {
    public static void main(String ...args){
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<Integer>());
        connections.get(0).add(0);
        connections.get(0).add(1);

        connections.add(new ArrayList<Integer>());
        connections.get(1).add(1);
        connections.get(1).add(2);

        connections.add(new ArrayList<Integer>());
        connections.get(2).add(2);
        connections.get(2).add(0);

        connections.add(new ArrayList<Integer>());
        connections.get(3).add(1);
        connections.get(3).add(3);

        connections.add(new ArrayList<Integer>());
        connections.get(4).add(3);
        connections.get(4).add(4);

        connections.add(new ArrayList<Integer>());
        connections.get(5).add(4);
        connections.get(5).add(5);

        connections.add(new ArrayList<Integer>());
        connections.get(6).add(5);
        connections.get(6).add(3);


        List<List<Integer>> result = criticalConnections(7, connections);

        result.stream().forEach(v -> {
            v.stream().forEach(System.out::print);
            System.out.println();
        });

    }



    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(connections == null){
            return null;
        }
        Map<Integer, List<Integer>> graph = createGraph(connections, n);

        List<List<Integer>> result = new ArrayList<>();

        int[] discovery = new int[n];
        int[] lowlink = new int[n];
        int[] parent = new int[n];
        Arrays.fill(discovery,-1);
        Arrays.fill(lowlink,-1);
        Arrays.fill(parent,-1);

        boolean[] visited = new boolean[n];
        for(int i =0; i < n; i++){
            if(!visited[i]){
                dfs(0, discovery, lowlink, parent, graph, result, 0, visited);
            }
        }

        return result;
    }

    public static void dfs(int u, int [] discovery, int[] lowlink, int [] parent, Map<Integer, List<Integer>> graph, List<List<Integer>> result, int time, boolean [] visited){
        discovery[u] = time;
        lowlink[u] = time;
        time += 1;
        visited[u] = true;
        for(Integer v: graph.get(u)){
            if(!visited[v]){
                parent[v] = u;
                dfs(v, discovery, lowlink, parent, graph, result, time, visited);
                lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                if(lowlink[v] > discovery[u]){
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(u);
                    subRes.add(v);
                    result.add(subRes);
                }
            }else if(v != parent[u]){
                lowlink[u] = Math.min(lowlink[u], discovery[v]);
            }
        }

    }

    private static Map<Integer, List<Integer>> createGraph(List<List<Integer>> connections, int n){
        Map<Integer, List<Integer>>  graph = new HashMap<>();

        for(List<Integer> subList: connections){
            graph.computeIfAbsent(subList.get(0),k -> new ArrayList<>()).add(subList.get(1));
            graph.computeIfAbsent(subList.get(1),k -> new ArrayList<>()).add(subList.get(0));
        }

        return graph;
    }
}
