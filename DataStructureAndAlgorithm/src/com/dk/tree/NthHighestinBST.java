package com.dk.tree;

public class NthHighestinBST {
    public static int currentCount = 0;
    public static void main(String[] args){
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right.right = new Node(350);
        root.right.left = new Node(125);

        System.out.println(findNthHighestInBST(root, 3).val);

    }
    public static Node findNthHighestInBST(Node node, int n) {
        if(node == null){
            return null;
        }

        Node result = findNthHighestInBST(node.right, n);

        if(result != null){
            return result;
        }
        currentCount++;
        if(currentCount == n){
            return node;
        }
        result = findNthHighestInBST(node.left, n);
        if(result != null){
            return result;
        }
        return null;
    }
}
