package com.dk.codeproblems;

class Intersect{
    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode list1Node = null;
        int node1Length = get_length(head1);
        LinkedListNode list2Node = null;
        int node2Length = get_length(head2);
        int diff = 0;
        if(node1Length >= node2Length){
            list1Node = head1;
            list2Node = head2;
            diff = node1Length - node2Length;
        }else{
            list1Node = head2;
            list2Node = head1;
            diff = node2Length - node1Length;
        }

        while(diff > 0){
            list1Node = list1Node.next;
            diff--;
        }

        while(list1Node != null){
            if(list1Node == list2Node){
                return list1Node;
            }
            list1Node = list1Node.next;
            list2Node = list2Node.next;
        }


        return null;
    }

    public static int get_length(LinkedListNode head){
        int length = 0;
        LinkedListNode curr = head;
        while(curr != null){
            curr = curr.next;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        int [] a1 = {13,4};
        int [] a2 = {29, 23, 82, 11};
        LinkedListNode list_head_1 = LinkedList.createLinkedList(a1);
        LinkedListNode list_head_2 = LinkedList.createLinkedList(a2);
        LinkedListNode node1 = new LinkedListNode(12);
        LinkedListNode node2 = new LinkedListNode(27);

        LinkedList.insertAtTail(list_head_1, node1);
        LinkedList.insertAtTail(list_head_1, node2);

        LinkedList.insertAtTail(list_head_2, node1);
        //LinkedList.insertAtTail(list_head_2, node2);

        System.out.print("List 1: ");
        LinkedList.display(list_head_1);
        System.out.print("List 2: ");
        LinkedList.display(list_head_2);

        LinkedListNode intersect_node = intersect(list_head_1, list_head_2);
        System.out.println(String.format("Intersect at %d", intersect_node.data));
    }
}