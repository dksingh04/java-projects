package com.dk.codeproblems;

public class AddTwoIntegersInLinkedList {
    public static void main(String[] args) {

        int[] v1 = new int[]{1, 0, 9, 9}; // 1099
        int[] v2 = new int[]{7, 3, 2}; // 732

        LinkedListNode first = LinkedList.createLinkedList(v1);
        LinkedListNode second = LinkedList.createLinkedList(v2);
        LinkedList.display(first);
        LinkedListNode result = addIntegers(first, second);

        System.out.printf("First integer: ");
        LinkedList.display(first);
        System.out.printf("Second integer: ");
        LinkedList.display(second);

        System.out.printf("Result: ");
        LinkedList.display(result);
    }

    public static LinkedListNode addIntegers(LinkedListNode first, LinkedListNode second){
        LinkedListNode result = null;
        LinkedListNode last = null;
        int carry = 0;

        while(first != null || second != null || carry > 0){
            int fVal = (first == null?0:first.data);
            int sVal = (second == null?0:second.data);

            int sumVal = fVal + sVal + carry;
            LinkedListNode pNew = new LinkedListNode(sumVal%10);
            carry = sumVal/10;

            if(result == null){
                result = pNew;
            }else{
                last.next = pNew;
            }

            last = pNew;

            if(first != null){
                first = first.next;
            }

            if(second != null){
                second = second.next;
            }
        }


        return result;
    }
}
