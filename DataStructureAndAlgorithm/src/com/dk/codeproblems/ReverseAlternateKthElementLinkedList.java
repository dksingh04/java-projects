package com.dk.codeproblems;

public class ReverseAlternateKthElementLinkedList {
    public static void main(String ...args){
        int[] v1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedListNode listHead = LinkedList.createLinkedList(v1);
        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = reverseKthAlternateNodes(listHead, 3);
        System.out.print("List reversed by 4: ");
        LinkedList.display(listHead);
    }

    public static LinkedListNode reverseKthAlternateNodes(LinkedListNode head, int k){

        if(head == null && k <= 1){
            return head;
        }

        LinkedListNode reversed = null;
        LinkedListNode prvTail = null;

        while (head != null && k > 0){
            LinkedListNode currHead = null;
            LinkedListNode currTail = head;

            int n = k;

            while(n > 0 && head != null){
                LinkedListNode temp = head.next;
                head.next = currHead;
                currHead = head;
                head = temp;
                n--;
            }

            if(reversed == null){
                reversed = currHead;
            }

            if(prvTail != null){
                prvTail.next = currHead;
            }

            prvTail = currTail;
        }

        return reversed;
    }

}
