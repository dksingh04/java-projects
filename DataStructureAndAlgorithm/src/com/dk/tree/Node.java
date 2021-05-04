package com.dk.tree;

public class Node{
    private Node left, right;
    private int data;
    public Node(int data){
        this.data = data;
    }

    public void insert(int value){
        if(value <= data){
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
        if(data == value){
            return true;
        }else if(value <= data){
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
        System.out.println(data);
        if(right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.println(data);
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
        System.out.println(data);
    }

}