package com.dk.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndInOrderArray {
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String ...args){
        Node tree = buildTree(new int[]{9,3,15,20,7}, new int[]{3,9,20,15,7});
        tree.printInOrder();
    }

    public static Node buildTree(int[] inorder, int[] preorder){
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return  buildTree(0, 0, inorder.length-1, preorder);
    }

    public static Node buildTree(int preIndex, int inStart, int inEnd, int []preorder){
        if(preIndex > preorder.length - 1 || inStart > inEnd){
            return null;
        }

        Node root = new Node(preorder[preIndex]);
        int inIndex = map.get(preorder[preIndex]);
        root.left = buildTree(preIndex + 1, inStart, inIndex - 1, preorder);
        root.right = buildTree(preIndex + inIndex - inStart + 1, inIndex + 1, inEnd, preorder);
        return root;
    }
}
