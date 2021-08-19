package com.dk.tree;

public class PrintTreePerimeter {
    public static void main(String ...args){
        // Build Tree
        /*Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(25);
        root.left.right = new Node(60);
        root.left.left.left = new Node(10);
        root.left.right.right = new Node(70);
        root.right.right = new Node(350);
        root.right.right.right = new Node(400);

         */

        // Build Tree
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(25);
        root.left.right = new Node(60);
        root.left.left.left = new Node(10);
        root.left.right.right = new Node(70);
        root.right.right = new Node(350);
        root.right.right.right = new Node(400);
        root.right.right.right.left = new Node(360);
        root.right.right.right.left.left = new Node(370);
        root.right.right.right.left.right = new Node(380);
        root.left.right.right.right = new Node(90);
        root.right.right.right.right = new Node(450);
        root.right.right.right.right.right = new Node(460);

        printTreePerimeter(root);
    }

    public static void printTreePerimeter(Node root){
        if(root != null){
            //Print left perimeter
            System.out.print(root.val+" ");
            printLeftTreePerimeter(root.left);
            //Print leaf nodes
            printLeafNodes(root.left);
            printLeafNodes(root.right);
            //Print right perimeter
            printRightTreePerimeter(root.right);
        }
    }

    private static void printLeftTreePerimeter(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            System.out.print(root.val+" ");
            printLeftTreePerimeter(root.left);
        }else if(root.right != null){
            System.out.print(root.val+" ");
            printLeftTreePerimeter(root.right);
        }
    }

    private static void printRightTreePerimeter(Node root){
        if(root == null){
            return;
        }
        if(root.right != null){
            printRightTreePerimeter(root.right);
            System.out.print(root.val+" ");
        }else if(root.left != null){
            printRightTreePerimeter(root.left);
            System.out.print(root.val+" ");
        }
    }

    private static void printLeafNodes(Node root){
        if(root == null){
            return;
        }
        printLeafNodes(root.left);
        if(root.left == null && root.right == null){
            System.out.print(root.val+" ");
        }
        printLeafNodes(root.right);
    }
}
