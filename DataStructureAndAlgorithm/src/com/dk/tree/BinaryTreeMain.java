package com.dk.tree;

public class BinaryTreeMain {

    public static void main(String ...args){
        Node tree = new Node(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(8);

        tree.printInOrder();
        tree.printPreOrder();
        tree.printPostOrder();

        System.out.println(tree.containsInBinaryTree(8));
        System.out.println(tree.containsInBinaryTree(12));
    }


}
