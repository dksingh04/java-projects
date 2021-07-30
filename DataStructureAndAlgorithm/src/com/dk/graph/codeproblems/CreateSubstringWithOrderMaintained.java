package com.dk.graph.codeproblems;

import java.util.*;

public class CreateSubstringWithOrderMaintained {
    /*
        1st:
        Given a string containing [a,b,c] , create a substring containing the combination of abc such that the order is maintained.
        IN: abc
        OP: abc

        IN: aabbcc
        OP: abc, aabc, abbc, abcc, aabbc, aabcc, abbcc, aabbcc

     */

    public static void  main(String ...args){
        // build graph
        String text = "aabbcc";
        Map<String, List<TextNode>> graph = getTextGraph(text);
        TextNode  src = new TextNode("a", "a");
        TextNode  dest = new TextNode("c1", "c");
        findPaths(graph, src, dest);

    }
    private static boolean isNotVisited(TextNode x,
                                        List<TextNode> path)
    {
        int size = path.size();
        for(int i = 0; i < size; i++)
            if (path.get(i).getKey() == x.getKey())
                return false;

        return true;
    }

    private static void printPath(List<TextNode> path)
    {
        for(TextNode v : path)
        {
            System.out.print(v.getVal());
        }
        System.out.println();
    }

    private static void findPaths(Map<String, List<TextNode>> graph, TextNode src, TextNode dest){
        Queue<List<TextNode>> queue = new LinkedList<>();
        List<TextNode> path = new ArrayList<>();
        path.add(src);
        queue.offer(path);

        while(!queue.isEmpty()){
            path = queue.poll();
            TextNode last = path.get(path.size() - 1);

            // If last vertex is the desired destination
            // then print the path
            if (last.getKey().equals(dest.getKey())){
                printPath(path);
            }

            // Traverse to all the nodes connected to
            // current vertex and push new path to queue
            List<TextNode> lastNode = graph.get(last.getKey());
            for(int i = 0; i < lastNode.size(); i++)
            {
                if (isNotVisited(lastNode.get(i), path))
                {
                    List<TextNode> newpath = new ArrayList<>(path);
                    newpath.add(lastNode.get(i));
                    queue.offer(newpath);
                }
            }
        }

    }

    private static Map<String, List<TextNode>> getTextGraph(String text){
        Map<String, List<TextNode>> graphMap = new LinkedHashMap<>();
        List<TextNode> texNodeList = new ArrayList<>();
        if(!text.isEmpty()) {
            String c = text.substring(0, 1);
            TextNode textNode = new TextNode(c, c);
            texNodeList.add(textNode);
            graphMap.put(c, new ArrayList<>());
            int dup = 1;
            //create All Nodes
            for (int i = 1; i < text.length(); i++) {
                if(text.charAt(i) == text.charAt(i -1)){
                    graphMap.put(text.substring(i, i + 1)+dup, new ArrayList<>());
                    texNodeList.add(new TextNode(text.substring(i, i + 1)+dup, text.substring(i, i + 1)));
                    dup++;
                }else{
                    dup = 1;
                    graphMap.put(text.substring(i, i + 1), new ArrayList<>());
                    texNodeList.add(new TextNode(text.substring(i, i + 1), text.substring(i, i + 1)));
                }
            }
        }
        //Connect all nodes
        graphMap.get("a").add(texNodeList.get(1));
        graphMap.get("a1").add(texNodeList.get(2));
        graphMap.get("a").add(texNodeList.get(2));
        graphMap.get("b").add(texNodeList.get(3));
        graphMap.get("b1").add(texNodeList.get(4));
        graphMap.get("b").add(texNodeList.get(4));
        graphMap.get("b1").add(texNodeList.get(5));
        graphMap.get("b").add(texNodeList.get(5));
        graphMap.get("c").add(texNodeList.get(5));

        return graphMap;

    }


}

 class TextNode{
    String key;
    String val;

    public TextNode(String key, String val){
        this.key = key;
        this.val = val;
    }

     public String getKey() {
         return key;
     }

     public String getVal() {
         return val;
     }
 }
