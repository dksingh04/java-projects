package com.dk.codeproblems;

class DeleteNode{
    public static LinkedListNode deleteNode(LinkedListNode head, int key)
    {
        if(head == null){
            return null;
        }

        LinkedListNode curr = head;
        while(curr.next != null){
            if(curr.next.data == key){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        if(head.data == key){
            head = head.next;
        }

        return head;
    }

    public static void main(String ...args){
        LinkedListNode listHead = null;
        int[] list1 = {20, 14,36, 11, 72, 41};
        listHead = LinkedList.createLinkedList(list1);
        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = deleteNode(listHead, 72);
        System.out.printf("After deleting 72 from list: ");
        LinkedList.display(listHead);
    }
}
