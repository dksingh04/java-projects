package com.dk.tree;

public class SymmetricTree {
    public static void main(String ...args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(2);
        tree.left.left = new Node(3);
        tree.left.right = new Node(4);

        tree.right.left = new Node(4);
        tree.right.right = new Node(3);

        System.out.println(pathSymmetric(tree));
    }

    public static boolean pathSymmetric(Node root){
        return checkPathSymmetric(root, root);
    }

    public static boolean checkPathSymmetric(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 != null && node2 != null && node1.val == node2.val){
            return checkPathSymmetric(node1.left, node2.right) && checkPathSymmetric(node1.right, node2.left);
        }

        return false;
    }
}
