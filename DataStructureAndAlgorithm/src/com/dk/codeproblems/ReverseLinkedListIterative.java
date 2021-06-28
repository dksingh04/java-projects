package com.dk.codeproblems;
public class ReverseLinkedListIterative {

    public static  LinkedListNode reverse(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode toDoList = null;
        LinkedListNode reversedList =  new LinkedListNode(head.data);
        toDoList = head.next;
        reversedList.next = null;

        while(toDoList != null){
            //Handle Circular LinkedList case.
            if(toDoList == head){
                break;
            }
            //this will assure that original head didn't modified.
            LinkedListNode temp = new LinkedListNode(toDoList.data);
            toDoList = toDoList.next;
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

    }
}
