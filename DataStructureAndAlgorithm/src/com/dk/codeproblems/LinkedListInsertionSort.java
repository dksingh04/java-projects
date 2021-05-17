package com.dk.codeproblems;

class LinkedListInsertionSort{
    public static LinkedListNode insertionSort(LinkedListNode head) {

        if(head == null){
            return head;
        }
        LinkedListNode sorted = null;
        LinkedListNode curr = head;

        while (curr != null){
             LinkedListNode temp = curr.next;
             sorted = sortedLinkedList(sorted, curr);
             curr = temp;
        }

        return sorted;
    }

    public static LinkedListNode sortedLinkedList(LinkedListNode head, LinkedListNode node){
        if(node == null){
            return head;
        }

        if(head == null || node.data <= head.data){
            node.next = head;
            return node;
        }

        LinkedListNode curr = head;

        while(curr.next != null && curr.next.data < node.data){
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;

        return head;
    }

    public static void main(String[] args) {

        int[] list = {29, 23, 82, 11, 75};
        int[] listExpected = {11, 23, 29, 75, 82};
        LinkedListNode listHead = LinkedList.createLinkedList(list);
        LinkedListNode listHeadExpected = LinkedList.createLinkedList(listExpected);

        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = insertionSort(listHead);
        System.out.print("After sorting: ");
        LinkedList.display(listHead);
    }
}
