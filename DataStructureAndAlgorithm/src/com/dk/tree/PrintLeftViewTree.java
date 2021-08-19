package com.dk.tree;

public class PrintLeftViewTree {
    static int maxLevel = 0;
    public static void main(String ...args){
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
        maxLevel = 0;
        printLeftViewTree(root);
    }

    public static void printLeftViewTree(Node root){
        if(root != null){
            //Print left perimeter
            System.out.print(root.val+" ");
            printLeftView(root.left, 1);
            System.out.println();
            maxLevel = 0;
            printRightView(root.right, 1);
        }
    }

    public static void printLeftView(Node root, int level){
        if(root == null){
            return;
        }
        //System.out.println("maxLevel:"+ maxLevel +" level: "+ level);
        if(maxLevel < level){
            System.out.print(root.val+" ");
            maxLevel = level;
        }

        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);

    }

    public static void printRightView(Node root, int level){
        if(root == null){
            return;
        }
        //System.out.println("maxLevel:"+ maxLevel +" level: "+ level);
        if(maxLevel < level){
            System.out.print(root.val+" ");
            maxLevel = level;
        }

        printRightView(root.right, level + 1);
        printRightView(root.left, level + 1);


    }
}
