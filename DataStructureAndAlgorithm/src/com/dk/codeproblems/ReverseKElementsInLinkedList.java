package com.dk.codeproblems;

public class ReverseKElementsInLinkedList {

    public static void main(String ...args){
        int[] v1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedListNode listHead = LinkedList.createLinkedList(v1);
        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = reverseKNodes(listHead, 4);
        System.out.print("List reversed by 4: ");
        LinkedList.display(listHead);
    }


    public static LinkedListNode reverseKNodes(LinkedListNode head, int k){
        if(head == null || k <= 1){
            return head;
        }

        LinkedListNode curr = head;
        LinkedListNode reversNodeList = null;
        int i = k;
        while(k >= 1 && curr != null){
            LinkedListNode temp = curr;
            curr = curr.next;
            temp.next = reversNodeList;
            reversNodeList = temp;
            k--;
        }

        LinkedListNode currReverseList = reversNodeList;
        while (currReverseList.next != null){
            currReverseList = currReverseList.next;
        }
        while (curr != null){
            currReverseList.next = curr;
            curr = curr.next;
            currReverseList = currReverseList.next;
        }

        return reversNodeList;
    }
}
