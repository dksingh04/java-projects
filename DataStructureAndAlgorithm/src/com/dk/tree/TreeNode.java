package com.dk.tree;

import java.util.ArrayList;

public class TreeNode {
        public int data;
        public String text;
        public ArrayList<TreeNode> Children = new ArrayList<TreeNode>();
        public TreeNode(int data){
            this.data = data;
        }

        public TreeNode(String text){
            this.text = text;
        }
}
