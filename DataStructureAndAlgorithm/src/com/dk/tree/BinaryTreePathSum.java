package com.dk.tree;

public class BinaryTreePathSum {
    public static void main(String ...args){
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(1);

        System.out.println(pathSum(root, 22));

    }

    public static boolean pathSum(Node root, int targetSum){
        if(root == null){
            return false;
        }

        return pathSum(root, 0, targetSum);
    }

    public static boolean pathSum(Node root, int currentSum, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null) {
            if (root.val + currentSum == targetSum) {
                return true;
            }
        }

        return pathSum(root.left, root.val+currentSum, targetSum)
                    || pathSum(root.right, root.val+currentSum, targetSum);
        }
}
