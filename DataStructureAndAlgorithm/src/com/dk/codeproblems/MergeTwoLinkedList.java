package com.dk.codeproblems;

public class MergeTwoLinkedList {
    public static void main(String ...args){
        int [] a1 = {4,13};
        int [] a2 = {11, 23, 29, 82};
        LinkedListNode list_head_1 = LinkedList.createLinkedList(a1);
        LinkedListNode list_head_2 = LinkedList.createLinkedList(a2);
        LinkedListNode mergedList = mergeTwoLists(list_head_1, list_head_2);
        LinkedList.display(mergedList);
    }

    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 != null && l2 == null){
            return l1;
        }

        if(l2!= null && l1 == null){
            return l2;
        }
        LinkedListNode l1C = l1;
        LinkedListNode l2C = l2;

        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode mergedList = head;

        while( l1C!= null && l2C != null){
            if(l1C.data < l2C.data){
                mergedList.next = l1C;
                l1C = l1C.next;
            }else{
                mergedList.next = l2C;
                l2C = l2C.next;
            }
            mergedList = mergedList.next;
        }

        if(l1C != null){
            mergedList.next = l1C;
        }

        if(l2C != null){
            mergedList.next = l2C;
        }

        return head.next;
    }
}
