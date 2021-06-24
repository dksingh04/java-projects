package com.dk.linkedlist;

public class DelteNthNodeFromLast {


     // Definition for singly-linked list.



    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null){
                return head;
            }

            int len = getLen(head);
            if(n > len){
                return null;
            }
            ListNode curr = head;

            int nthNode = len - n;
            //If node is first node.
            if(nthNode == 0){
                curr = curr.next;
                head = curr;
                return head;
            }
            // Go till one node before the deleted Node.
            nthNode = nthNode - 1;

            int i = 0;

            while(i < nthNode){
                i++;
                curr = curr.next;
            }

            if(curr != null && curr.next != null){
                curr.next = curr.next.next;
            }

            return head;
        }

        public int getLen(ListNode node){
            int len = 0;
            ListNode curr = node;
            while(curr != null){
                curr = curr.next;
                len++;
            }

            return len;
        }
    }
}
