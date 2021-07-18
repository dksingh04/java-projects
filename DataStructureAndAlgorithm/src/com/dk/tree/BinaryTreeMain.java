package com.dk.tree;

public class BinaryTreeMain {

    public static void main(String ...args){
     /*   Node tree = new Node(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(8);

        tree.printInOrder();
        tree.printPreOrder();
        tree.printPostOrder();

        System.out.println(tree.containsInBinaryTree(8));
        System.out.println(tree.containsInBinaryTree(12));
      */
        Node tree1 = new Node(3);
        tree1.left = new Node(9);
        tree1.right = new Node(20);
       // tree1.left.left = new Node(4);

        //tree1.left.right = new Node(6);
        tree1.right.left = new Node(15);
        tree1.right.right = new Node(7);

        tree1.printInOrder();
        System.out.println();
        tree1.printPostOrder();
    }


}
