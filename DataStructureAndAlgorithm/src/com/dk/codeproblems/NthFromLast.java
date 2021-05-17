package com.dk.codeproblems;

class NthFromLast{
    public static LinkedListNode findNthFromLast(LinkedListNode head, int n) {
        LinkedListNode tail = head;
        while(tail != null && n > 0){
            tail = tail.next;
            --n;
        }
        if(n != 0){
            return null;
        }

        while(tail != null){
            tail = tail.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode listHead = null;
        int []arr = {7, 14, 21, 28, 35, 42};

        listHead = LinkedList.createLinkedList(arr);
        System.out.print("List: ");
        LinkedList.display(listHead);

        LinkedListNode temp = findNthFromLast(listHead, 3);
        System.out.println(String.format("3rd element from last: %d", temp.data));
    }
}