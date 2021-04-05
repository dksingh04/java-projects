package com.dk.codeproblems;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        //no need to reverse if head is
        //null or there is only 1 node.
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode reversedList = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return reversedList;
    }
    public static void main(String[] args) {
        LinkedListNode listHead = null;
        int [] arr = {7, 14, 21, 28};
        listHead = LinkedList.createLinkedList(arr);

        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = reverse(listHead);
        System.out.print("After Reverse: ");
        LinkedList.display(listHead);
    }
}
