package com.dk.linkedlist;

public class CheckPalendromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //ListNode tempHead = head;
        ListNode reversedList = new ListNode(head.val);
        ListNode remainingList = head.next;
        reversedList.next = null;
        while (remainingList != null) {
            ListNode temp = new ListNode(remainingList.val);
            remainingList = remainingList.next;
            temp.next = reversedList;
            reversedList = temp;
        }

        ListNode curr = head;
        ListNode rCurr = reversedList;
        while (rCurr != null) {
            System.out.println(curr.val);
            if (curr.val != rCurr.val) {
                return false;
            }

            curr = curr.next;
            rCurr = rCurr.next;
        }

        return true;
    }

    public static  void main(String ...args){

    }
}
