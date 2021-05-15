package com.dk.codeproblems;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String ...args){
        int[] list1 = {4, 7, 4, 9, 7, 11, 4};
        int[] list1Expected = {4, 7, 9, 11};

        LinkedListNode listHead1 = LinkedList.createLinkedList(list1);
        LinkedListNode listHead1_expected = LinkedList.createLinkedList(list1Expected);

        System.out.print("Original: ");
        LinkedList.display(listHead1);
        listHead1 = removeDuplicates(listHead1);

        System.out.print("After removing duplicates: ");
        LinkedList.display(listHead1);
    }

    public static LinkedListNode removeDuplicates(LinkedListNode head){
        if(head == null){
            return head;
        }
        Set<Integer> s = new HashSet<>();
        LinkedListNode curr = head;
        s.add(curr.data);

        while(curr.next != null){
            if(!s.contains(curr.next.data)){
                s.add(curr.next.data);
                curr = curr.next;
            }else{
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}
