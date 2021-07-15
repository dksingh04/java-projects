package com.dk.tree;

public class Node{
    public Node left, right;
    public int val;
    public Node(int data){
        this.val = data;
    }

    public void insert(int value){
        if(value <= val){
            if(left == null){
                left = new Node(value);
            }else{
                left.insert(value);
            }
        }else{
            if(right == null){
                right = new Node(value);
            }else{
                right.insert(value);
            }
        }
    }

    public boolean containsInBinaryTree(int value){
        if(val == value){
            return true;
        }else if(value <= val){
            if(left == null){
                return false;
            }else{
                return left.containsInBinaryTree(value);
            }

        }else{
            if(right == null){
                return false;
            }else{
                return right.containsInBinaryTree(value);
            }
        }
    }

    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        System.out.println(val);
        if(right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.println(val);
        if(left != null){
            left.printInOrder();
        }
        if(right != null){
            right.printInOrder();
        }
    }
    public void printPostOrder(){
        if(left != null){
            left.printInOrder();
        }
        if(right != null){
            right.printInOrder();
        }
        System.out.println(val);
    }

}