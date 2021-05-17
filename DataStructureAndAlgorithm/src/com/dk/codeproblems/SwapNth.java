package com.dk.codeproblems;

class SwapNth{
    // Node indices starts from 1.
    static LinkedListNode swapNthNode(LinkedListNode head, int n) {
        if(n == 1){
            return head;
        }
        if(head == null){
            return head;
        }
        LinkedListNode nthNode = findNthNode(head, n-2);

        LinkedListNode currNode = nthNode.next;
        LinkedListNode nextHead = head.next;
        nthNode.next = head;
        head.next = currNode.next;
        head = currNode;
        currNode.next = nextHead;

        return head;
    }

    static LinkedListNode findNthNode(LinkedListNode head, int n){
        LinkedListNode curr = head;

        while(curr != null && n > 0){
            curr = curr.next;
            --n;
        }

        if(n != 0){
            return head;
        }

        return curr;
    }

    public static void main(String[] args) {
        LinkedListNode listHead = null;
        int[] arr = new int[] {7, 14, 21, 28, 35, 42};
        listHead = LinkedList.createLinkedList(arr);

        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = swapNthNode(listHead, 4);
        System.out.print("Swapping 4th node with head: ");
        LinkedList.display(listHead);
    }
}