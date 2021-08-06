package com.dk.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesNextPointerUnbalancedTree {

    /*Given a binary tree

    struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.



    Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


            Example 1:



    Input: root = [1,2,3,4,5,null,7]
    Output: [1,#,2,3,#,4,5,7,#]
    Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

     */

    public static void main(String ...args){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        //tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        Node node = connectIterative(tree);
        System.out.println(node);
    }

    public static void connectRecursive(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if(root.right != null){
            root.right.next = getNext(root.next);
        }


        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }else{
                root.left.next = getNext(root.next);
            }
        }

        connectRecursive(root.right);
        connectRecursive(root.left);


    }

    private static Node getNext(Node node){
        while(node != null){
            if(node.left != null){
                return node.left;
            }
            if(node.right != null){
                return node.right;
            }
            node = node.next;
        }

        return node;
    }

    public static Node connectWithQueue(Node root){
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            while(size > 0){
                Node node = queue.poll();
                if(prev!=null) {
                    prev.next = node;
                }
                prev = node;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;
            }

        }
        return root;

    }

    public static Node connectIterative(Node root) {
        if(root == null){
            return null;
        }

        Node curr = root;
        while(curr != null && (curr.left != null || curr.right != null)){
            Node nextLevel = curr.left!= null?curr.left:curr.right;

            while(curr != null){
                if(curr.left != null){
                    curr = leftConnect(curr);
                }else if(curr.right != null){
                    curr = rightConnect(curr);
                }

                if(curr.next == null){
                    nextNullConnect(curr);
                }else{
                    if(curr.right != null){
                        curr = rightConnect(curr);
                    }else if(curr.left != null){
                        curr = leftConnect(curr);
                    }
                }

                curr = curr.next;
            }
            while(nextLevel!= null && (nextLevel.left == null && nextLevel.right == null)){
                nextLevel = nextLevel.next;
            }
            curr = nextLevel;

        }

        return root;
    }

    private static Node leftConnect(Node curr){
        Node temp = curr;
        if(curr.right != null){
            curr.left.next = temp.right;
        }else{
            if(temp.next == null){
                curr.left.next = null;
            }else{
                while(temp.next != null){
                    if(temp.next != null && (temp.next.left != null || temp.next.right != null)){
                        curr.left.next = temp.next.left != null ? temp.next.left:temp.next.right;
                        break;
                    }else{
                        temp = temp.next;
                    }
                }
            }
        }
        return temp;
    }

    private static Node rightConnect(Node curr){
        Node temp = curr;
        if(temp.next == null){
            curr.right.next = null;
        }else{
            while(temp.next != null){
                if(temp.next != null && (temp.next.left != null || temp.next.right != null)){
                    curr.right.next = temp.next.left != null ? temp.next.left:temp.next.right;
                    break;
                }else{
                    temp = temp.next;
                }
            }
        }
        return temp;
    }

    private static void nextNullConnect(Node curr){
        if(curr.left != null){
            if(curr.right != null){
                curr.left.next = curr.right;
                curr.right.next = null;
            }else{
                curr.left.next = null;
            }
        }else if(curr.right != null){
            curr.right.next = null;
        }
    }
}
