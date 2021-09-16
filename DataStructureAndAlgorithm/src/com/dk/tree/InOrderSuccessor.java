package com.dk.tree;

public class InOrderSuccessor {
    public static void main(String ...args){
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(25);
        root.left.right = new Node(75);
        root.right.left = new Node(125);
        root.right.right = new Node(350);

        System.out.println(inorderSuccessorBST(root, 350));
    }

    static Node successor = null;
    static Node inorderSuccessorBST(Node root, int d) {
        if(root == null){
            return null;
        }
        if(root.val < d){
            inorderSuccessorBST(root.right, d);
        }else if(root.val > d){
            successor = root;
            inorderSuccessorBST(root.left, d);
        }else {
            if(root.right != null){
                Node t = root.right;
                while(t.left != null){
                    t = t.left;
                }
                successor = t;
            }
        }
        return successor;
    }
}
