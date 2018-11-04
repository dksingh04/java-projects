package com.dk.linkedlist;
/**
 * 
 * @author Deepak
 * Dubly linked list example
 * @param <T>
 */
public class Node<T> {
	
	T data;
	Node<T> next;
	Node<T> prv;
	
	public Node(T data){
		this.data = data;
		this.next = null;
		this.prv = null;
	}
	
	

}
