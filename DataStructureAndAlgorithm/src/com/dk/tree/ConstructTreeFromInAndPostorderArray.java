package com.dk.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPostorderArray {
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String ...args){
        Node tree = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        tree.printInOrder();
    }

    public static Node buildTree(int[] inorder, int[] postorder){
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return  buildTree(postorder.length - 1, 0, inorder.length-1, postorder);
    }

    private static Node buildTree(int pIndex, int inStart, int inEnd, int[] postorder){
        if(inStart > inEnd){
            return null;
        }
        Node root = new Node(postorder[pIndex]);
        int inIndex = map.get(postorder[pIndex]);
        root.left = buildTree((pIndex - (inEnd - inIndex) - 1), inStart, inIndex - 1, postorder);
        root.right = buildTree(pIndex - 1, inIndex + 1, inEnd, postorder);
        return root;
    }
}
