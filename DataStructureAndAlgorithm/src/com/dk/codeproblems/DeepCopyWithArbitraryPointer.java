package com.dk.codeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DeepCopyWithArbitraryPointer {

    public static LinkedListNode deepCopyArbitraryPointer(LinkedListNode head){
        if(head == null){
            return head;
        }

        Map<LinkedListNode, LinkedListNode> map = new HashMap<>();
        LinkedListNode newHead = null;
        LinkedListNode newPrev = null;
        LinkedListNode curr = head;

        while(curr != null){
            LinkedListNode newNode = new LinkedListNode(curr.data);
            newNode.arbitraryPointer = curr.arbitraryPointer;
            if(newPrev != null){
                newPrev.next = newNode;
            }else{
                newHead = newNode;
            }

            newPrev = newNode;
            map.put(curr, newNode);
            curr = curr.next;
        }

        //Update arbitrary pointer in new Node
        LinkedListNode newCurrHead = newHead;
        while(newCurrHead != null){
            if(newCurrHead.arbitraryPointer != null){
                LinkedListNode node = map.get(newCurrHead.arbitraryPointer);
                newCurrHead.arbitraryPointer = node;
            }
            newCurrHead = newCurrHead.next;
        }

        return newHead;
    }
    public static LinkedListNode createLinkedListWithArbPointers (int length) {
        LinkedListNode head = LinkedList.createRandomList(length);
        ArrayList<LinkedListNode> v = new ArrayList<>();
        LinkedListNode temp = head;
        while (temp != null) {
            v.add(temp);
            temp = temp.next;
        }

        Random generator = new Random();
        for (int i = 0; i < v.size(); i++) {

            int j = (generator.nextInt((v.size() - 1)));
            int p = generator.nextInt(100);
            if (p < 75) {
                v.get(i).arbitraryPointer = v.get(j);
            }
        }
        return head;
    }

    public static String printWithArbPointers(LinkedListNode head) {
        String printedResult = "";
        while (head !=  null) {
            String temp = "";
            printedResult += head.data;
            if (head.arbitraryPointer != null) {
                temp += head.arbitraryPointer.data;
            }
            printedResult += " (" + temp + ")";
            head = head.next;
            if (head != null)
                printedResult += ", ";
        }
        return printedResult;
    }

    public static void main(String[] args) {
        LinkedListNode head = createLinkedListWithArbPointers(5);

        LinkedListNode head2 = deepCopyArbitraryPointer(head);

        System.out.print("Original list: " + printWithArbPointers(head));

        System.out.print("\nDeep copied list: "+ printWithArbPointers(head2));

        head = createLinkedListWithArbPointers(3);

        System.out.print("\nChanged original list: " + printWithArbPointers(head));

        System.out.print("\nUnchanged deep copied list: "+ printWithArbPointers(head2));
    }
}
