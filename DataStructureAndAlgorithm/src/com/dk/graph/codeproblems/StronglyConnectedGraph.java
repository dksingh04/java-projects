package com.dk.graph.codeproblems;

import java.util.*;

public class StronglyConnectedGraph {
    public static void main(String ...args){
        /*
          6
            [[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]

            Some defn:
            Tree Edge:  (u, v) -> u  is parent  and v is  child, so an edge will be called Tree Edge
                        if there is a  Parent and child relationship.

            Forward Edge: (u,v) -> u -  ancestor v - descendant, so if there is a relationship of ancestor and descendant
                          then an edge will be called Forward Edge.

           Backward Edge: (u, v) -> u  - descendant and v - ancestor so if there is a relationship between u and v is descendant
                          and ancestor then it is called as Backward Edge.
           Cross Edge:  (u, v) : There is no relationship between u and v.

         */

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

       /* connections.add(new ArrayList<Integer>());
        connections.get(7).add(4);
        connections.get(7).add(5);

        */

        List<Integer> result = stronglyConnections(7, connections);

        result.stream().forEach(System.out::print);
    }

    public  static List<Integer> stronglyConnections(int n, List<List<Integer>> connections){
        Map<Integer, List<Integer>>  graph = createGraph(connections, n);
        int[] discovery = new int[n];
        int[] lowlink = new int[n];
        int[] parent = new int[n];
        Arrays.fill(discovery, -1);
        Arrays.fill(lowlink, -1);
        Arrays.fill(parent, -1);
        boolean [] presentInStack = new boolean[n];
        Stack<Integer> stack  = new Stack<Integer>();
        List<Integer> result = new ArrayList<>();
        for(int  i = 0; i  < n;  i++){
            if(discovery[i] == -1){
                dfs(i,  discovery, lowlink, parent, graph, presentInStack, stack, result, 0);
            }
        }

        return result;
    }

    private static void dfs(int u, int [] discovery, int[] lowlink, int[] parent, Map<Integer, List<Integer>>  graph, boolean [] presentInStack,
                     Stack<Integer> stack, List<Integer> result, int times){
        discovery[u] = times;
        lowlink[u] = times;
        times += 1;
        presentInStack[u] = true;
        stack.push(u);
        //if(graph.get(u) )
        for(Integer v: graph.getOrDefault(u, new ArrayList<>())){
            if(v == parent[u]){
                continue;
            }
            if(discovery[v] == -1){ // if  not visited
                parent[v] = u;
                dfs(v, discovery, lowlink, parent, graph, presentInStack, stack, result, times);
                lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                if(lowlink[v] > discovery[u]){
                    System.out.println(u+","+v);
                }
            }else if(presentInStack[v]){ //i.e. already  visited (i.e. it is a Back Edge)
                //Differentiate back-edge and cross-edge
                lowlink[u] = Math.min(lowlink[u], discovery[v]);
            }
        }

        // collect all strongly connected components.
        if(lowlink[u] == discovery[u]){ // i.e. if u is a source node of strongly connected graph
            if(!stack.isEmpty()){
                int w = stack.pop();
                while(!stack.isEmpty() && w != u){
                    result.add(w);
                    presentInStack[w] = false;
                    w = stack.pop();
                }
                if(!stack.isEmpty()){
                    w = stack.pop();
                    result.add(w);
                    presentInStack[w] = false;
                    stack.pop();
                }
            }

        }

    }

    private static Map<Integer, List<Integer>> createGraph(List<List<Integer>> connections, int n){
        Map<Integer, List<Integer>>  graph = new HashMap<>();

        for(List<Integer> subList : connections){
            graph.computeIfAbsent(subList.get(0),k -> new ArrayList<>()).add(subList.get(1));
            graph.computeIfAbsent(subList.get(1),k -> new ArrayList<>()).add(subList.get(0));
        }


      /*  graph.computeIfAbsent(0, k -> new ArrayList<>()).add(1);
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(3);
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(4);
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(0);
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(5);
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(6);
        graph.computeIfAbsent(5, k -> new ArrayList<>()).add(6);
        graph.computeIfAbsent(6, k -> new ArrayList<>()).add(5);

       */


        return graph;
    }
}
