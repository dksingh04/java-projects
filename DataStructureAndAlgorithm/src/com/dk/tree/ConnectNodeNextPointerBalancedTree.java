package com.dk.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectNodeNextPointerBalancedTree {

    public static Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);
        Node temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp != null){
                temp.next = queue.peek();
                if(temp.left != null){
                    queue.offer(temp.left);
                }

                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }else{
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }

        }

        return root;

    }

    public static Node connectIterative(Node root){
        if(root == null){
            return root;
        }
        Node curr = root;
        while(curr.left != null){
            Node nextLevel = curr.left;

            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next == null){
                    curr.right.next = null;
                }else{
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            curr = nextLevel;
        }

        return root;
    }


    public static void connectRecursive(Node root) {
        if (root == null) {
            return;
        }

        if(root.left != null){
            root.left.next = root.right;
        }


        if(root.right != null){
            if(root.next != null){
                root.right.next = root.next.left;
            }else{
                root.right.next = null;
            }
        }

        connectRecursive(root.left);
        connectRecursive(root.right);

    }

    public static void  main(String ...args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        Node node = connect(tree);
        System.out.println(node);
    }
}
