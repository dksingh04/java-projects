package com.dk.tree;
/*
        Delete Zero Sum Sub-Trees
        Delete any subtrees whose nodes sum up to zero for a given binary tree.
        https://www.educative.io/courses/coderust-hacking-the-coding-interview/mwvLp
 */
public class DeleteZeroSumSubTree {
    public static void main(String ...args){
        Node tree = new Node(7);
        tree.left = new Node(5);
        tree.right = new Node(6);
        tree.left.left = new Node(-3);
        tree.left.right = new Node(-2);
        System.out.println("**********  Before  ****************");
        tree.printPreOrder();
        deleteZeroSumSubTree(tree);
        System.out.println();
        System.out.println("**********   After  ****************");
        tree.printPreOrder();
    }

    public static void deleteZeroSumSubTree(Node root){
        if(root == null){
            return;
        }

        if(0 == deleteZeroSumRec(root)){
            root = null;
        }

    }

    private static int deleteZeroSumRec(Node root){
        if(root == null){
            return 0;
        }
        int lsum = deleteZeroSumRec(root.left);
        int rsum = deleteZeroSumRec(root.right);

        if(lsum == 0){
            root.left = null;
        }

        if(rsum == 0){
            root.right = null;
        }
        return root.val + lsum + rsum;
    }
}
