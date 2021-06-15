package com.dk.codeproblems;

public class ReverseCyclicLinkedList {

    public static  LinkedListNode reverse(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode toDoList = null;
        LinkedListNode reversedList = head;
        toDoList = head.next;
        LinkedListNode fast = head.next;
        reversedList.next = null;


        while(toDoList != null){
            if(toDoList == head){
                break;
            }
            LinkedListNode temp = toDoList;
            toDoList = toDoList.next;
            if(fast != null && fast.next != null){
                fast = fast.next.next;
                if(fast == toDoList){
                    break;
                }
            }
            temp.next = reversedList;
            reversedList = temp;
        }

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

        // Handling Circular LinkedList case.
        int [] arr1 = {7, 14, 21, 28};
        listHead = LinkedList.createLinkedList(arr);
        listHead.next.next.next.next = listHead;
        System.out.print("Original: ");
        LinkedList.display(listHead);
        listHead = reverse(listHead);
        System.out.print("After Reverse: ");
        LinkedList.display(listHead);

        //LinkedListNode listHead = null;
        int [] arr2 = {7, 14, 21, 28};
        listHead = LinkedList.createLinkedList(arr2);
        listHead.next.next.next.next = listHead.next;
        System.out.print("Original: ");
        //LinkedList.display(listHead);
        listHead = reverse(listHead);
        System.out.print("After Reverse: ");
        LinkedList.display(listHead);

    }
}
