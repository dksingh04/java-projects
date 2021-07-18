package com.dk.linkedlist;

public class ReverseKthGroup {
    public static void main(String ...args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseKhGroupNode(head, 2);
        while (result != null){
            System.out.print(result.val +",");
            result = result.next;
        }
    }

    public static ListNode reverseKhGroupNode(ListNode head, int k){
        int l = getLength(head);
        int counts = l/k;
        ListNode resultHead = new ListNode(-1);
        resultHead.next = head;
        ListNode node = resultHead;
        while(counts > 0){
            node = reverseKthGroup(node, k);
            counts--;
        }

        return resultHead.next;
    }

    private static ListNode reverseKthGroup(ListNode node, int k){
        ListNode curr = node.next;
        ListNode reverse = null;
        ListNode tail = null;

        while(k > 0 && curr != null){
            ListNode newNode = curr.next;
            curr.next = reverse;
            reverse = curr;
            curr = newNode;
            if(reverse.next == null){
                tail = reverse;
            }
            k--;
        }
        tail.next = curr;
        node.next = reverse;
        return tail;
    }
    private static int getLength(ListNode head){
        int len = 0;
        ListNode curr = head;
        while (curr !=  null){
            curr = curr.next;
            len++;
        }

        return len;
    }
}
