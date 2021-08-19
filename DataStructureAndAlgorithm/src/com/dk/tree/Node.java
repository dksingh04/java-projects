package com.dk.tree;

public class Node{
    public Node left, right, next;
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
        System.out.print(val+",");
        if(right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.print(val+" ");
        if(left != null){
            left.printPreOrder();
        }
        if(right != null){
            right.printPreOrder();
        }

    }
    public void printPostOrder(){
        if(left != null){
            left.printPostOrder();
        }
        if(right != null){
            right.printPostOrder();
        }
        System.out.print(val+",");
    }

}