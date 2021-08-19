package com.dk.tree;

class MirrorBT{
    //https://www.educative.io/courses/coderust-hacking-the-coding-interview/jv72v
    /*
      Mirror Binary Tree Nodes
        Given the root node of a binary tree, swap the 'left' and 'right' children for each node.
     */

    public static void main(String ...args){
        Node tree = new Node(20);
        tree.left = new Node(50);
        tree.right = new Node(200);
        tree.left.left = new Node(75);
        tree.left.right = new Node(25);
        tree.right.right = new Node(300);
        System.out.println("********** Before Mirror *********");
        tree.printPreOrder();
        mirrorBinaryTree(tree);
        System.out.println();
        System.out.println("********** After Mirror *********");
        tree.printPreOrder();
    }
    public static void mirrorBinaryTree(Node root) {
        if(root == null){
            return;
        }

        if(root.left != null){
            mirrorBinaryTree(root.left);
        }

        if(root.right != null){
            mirrorBinaryTree(root.right);
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;



    }
}