package com.dk.linkedlist;

public class TestDoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dbList = new DoublyLinkedList<>();
		dbList.add(10);
		dbList.add(20);
		dbList.add(30);
		dbList.addAfter(new Node<Integer>(30), 40);
		dbList.addAfter(new Node<Integer>(70), 80);
		dbList.addBefore(new Node<Integer>(10), 90);
		dbList.add(60);
		dbList.append(70);
		dbList.addAfter(new Node<Integer>(70), 80);
		dbList.addBefore(new Node<Integer>(60), 50);
		System.out.println(dbList);
		System.out.println(dbList.search(20));
		dbList.add(60);
		System.out.println(dbList.size());
		dbList.remove(20);
		System.out.println(dbList.search(20));
		dbList.remove(60);
		System.out.println(dbList.size());
		dbList.remove(20);
		dbList.remove(60);
		dbList.remove(10);
		dbList.remove(30);
		System.out.println(dbList);
		System.out.println(dbList.size());
	}

}
