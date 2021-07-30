package com.dk.tree;

public class ISBSTTree {
    static Node prev = null;
    public static void main(String ...args){
        Node root = new Node(100);
        root.insert(50);
        root.insert(200);
        root.insert(25);
        root.insert(75);
        root.insert(125);
        root.insert(300);
        System.out.println(isBST(root));
    }

    public static boolean isBST(Node root){
        if(root == null){
            return true;
        }

        if(!isBST(root.left)){
            return false;
        }
        if(prev != null  && prev.val >= root.val){
            return false;
        }

        prev = root;

        if(!isBST(root.right)){
            return false;
        }
        return true;
    }
}
