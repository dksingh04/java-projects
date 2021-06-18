package com.dk.codeproblems;

public class RotateFromNthNode {

    public static void main(String ...args){
            int[] list1 = {1, 2, 3, 4, 5};
            LinkedListNode listHead = LinkedList.createLinkedList(list1);

            System.out.print("Original list: ");
            LinkedList.display(listHead);

            listHead = rotateList(listHead, 2);
            System.out.print("List rotated by 2: ");
            LinkedList.display(listHead);
    }

    private static LinkedListNode rotateList(LinkedListNode head, int n){

        if(head == null || n == 0){
            return head;
        }

        int len = len(head);

        n = adjustNthNode(n, len);

        //TODO rotate the list here
        int rotationPos = len - n - 1;
        LinkedListNode rotationNodeP = head;
        while(rotationPos > 0){
            rotationNodeP = rotationNodeP.next;
            --rotationPos;
        }

        LinkedListNode temp = rotationNodeP.next;
        LinkedListNode tempCurr = temp;
        while(tempCurr.next != null){
            tempCurr = tempCurr.next;
        }

        tempCurr.next = head;
        rotationNodeP.next = null;
        head = temp;

        return head;
    }

    private static int len(LinkedListNode head){
        int len = 0;
        LinkedListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }

        return len;
    }

    private static int adjustNthNode(int n, int len){
        n = n % len;
        if(n < 0){
            n = n + len;
        }
        return n;
    }
}
