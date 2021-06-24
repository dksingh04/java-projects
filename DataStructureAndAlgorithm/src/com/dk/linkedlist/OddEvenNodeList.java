package com.dk.linkedlist;

public class OddEvenNodeList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;

        ListNode headn = head.next;
        ListNode t1 = head; ListNode t2 = headn;

        while(t1.next!=null && t2.next!=null){
            t1.next = t2.next;
            t1=t1.next;
            t2.next = t1.next;
            t2=t2.next;
            if(t2==null) break;
        }
        t1.next = headn;
        return head;

    }
}
