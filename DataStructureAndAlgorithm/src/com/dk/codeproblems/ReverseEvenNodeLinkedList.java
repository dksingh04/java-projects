package com.dk.codeproblems;

public class ReverseEvenNodeLinkedList {
    public static void main(String ...args){
        int[] arr = {7, 14};
        LinkedListNode listHead = LinkedList.createLinkedList(arr);
        System.out.print("Original list: ");
        LinkedList.display(listHead);

        listHead = reverseEvenNodes(listHead);
        System.out.print("After Reverse: ");
        LinkedList.display(listHead);
    }

    public static LinkedListNode reverseEvenNodes(LinkedListNode head){

        LinkedListNode curr = head;
        LinkedListNode evenNodeList = null;

        while(curr != null && curr.next != null){
            LinkedListNode even = curr.next;
            curr.next = even.next;
            even.next = evenNodeList;
            evenNodeList = even;
            curr = curr.next;

        }

        LinkedList.display(evenNodeList);
        LinkedList.display(head);


        return mergeLinkedList(head, evenNodeList);
    }

    public static LinkedListNode mergeLinkedList(LinkedListNode head, LinkedListNode evenNodeList){

        if(head == null){
            return evenNodeList;
        }
        if(evenNodeList == null){
            return head;
        }
        LinkedListNode curr = head;
        LinkedListNode evenNode = evenNodeList;

        while((curr != null && curr.next != null) && evenNode != null){
            LinkedListNode temp = curr.next;
            curr.next = evenNode;
            evenNode = evenNode.next;
            curr = curr.next;
            curr.next = temp;
            curr = curr.next;
        }

        if(curr != null && curr.next == null){
            curr.next = evenNode;
        }
        LinkedList.display(head);
        return head;
    }
}
