package com.dk.tree;

public class MaximumDepthOfTree {

    public static void main(String ...args){
        Node tree = new Node(3);
        tree.left = new Node(9);
        tree.right = new Node(20);
        tree.right.left = new Node(15);
        tree.right.right = new Node(7);

        System.out.println(maxDepth(tree));
    }

    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        return maxDepth(root, 1, 1);
    }

    private static int maxDepth(Node root, int depth, int answer){
        if(root.left == null && root.right == null){
            answer = Math.max(depth, answer);
            return answer;
        }
        return Math.max(maxDepth(root.left, depth+1, answer), maxDepth(root.right, depth+1, answer));
    }

}
