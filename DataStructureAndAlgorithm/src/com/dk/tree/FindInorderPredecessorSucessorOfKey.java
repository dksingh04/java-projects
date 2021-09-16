package com.dk.tree;

public class FindInorderPredecessorSucessorOfKey {
    static Node predecessor, successor;
    public static void main(String ...args){
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.left.right = new Node(7);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);
        root.left.right.left = new Node(13);
        root.left.right.right = new Node(18);

        findInOrderSuccessorPredecessor(root, 10);

        System.out.println("Predecessor: "+predecessor.val);
        System.out.println("Successor: "+successor.val);

        findInOrderSuccessorPredecessor(root, 30);

        System.out.println("Predecessor: "+predecessor.val);
        System.out.println("Successor: "+successor.val);
    }

    public static void findInOrderSuccessorPredecessor(Node root, int key){
        if(root != null){
            if(root.val == key){
                if(root.left != null){
                    Node t = root.left;
                    while(t.right != null){
                        t = t.right;
                    }
                    predecessor = t;
                }
                if(root.right != null){
                    Node t = root.right;
                    while(t.left != null){
                        t = t.left;
                    }
                    successor = t;
                }
            }else if(root.val < key){
                predecessor = root;
                findInOrderSuccessorPredecessor(root.right, key);
            }else if(root.val > key){
                successor = root;
                findInOrderSuccessorPredecessor(root.left, key);
            }
        }

    }
}
