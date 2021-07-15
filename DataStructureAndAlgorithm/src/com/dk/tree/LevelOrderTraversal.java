package com.dk.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node currNode = queue.poll();

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }

                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
                temp.add(currNode.val);
            }
            result.add(temp);

        }

        return result;

    }

    public static void  main(String ...args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.right.right = new Node(5);

        List<List<Integer>> result = levelOrder(tree);
        System.out.println(result);
    }
}
