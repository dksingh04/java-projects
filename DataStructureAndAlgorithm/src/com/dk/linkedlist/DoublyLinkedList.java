package com.dk.linkedlist;

public class DoublyLinkedList<T> {
	private Node<T> head;
	/**
	 * Add the data at the head of the linked list
	 * @param data
	 */
	public void add(T data){
		Node<T> current = new Node<T>(data);
		if(this.head == null){
			this.head = current;
			return;
		}
		current.next=this.head;
		this.head.prv=current;		
		this.head = current;
	}
	/**
	 * Add the data after the given node in to the existing linked list
	 * @param prevNode
	 * @param data
	 * @return
	 */
	public boolean addAfter(Node<T> prevNode, T data){
		Node<T> current = this.head;
		Node<T> temp = new Node<>(data);
		while(current != null){
			if(prevNode.data.equals(current.data)){
				if(current.next == null){
					current.next = temp;
					temp.prv = current;
					return true;
				}else{
					temp.next = current.next;
					current.next.prv = temp;
					current.next = temp;
					temp.prv = current;
					return true;
				}
			}
			current = current.next;
		}
		
		return false;
		
	}
	/**
	 * Add the data before the given node in to the existing linked list 
	 * @param node
	 * @param data
	 * @return
	 */
	public boolean addBefore(Node<T> node, T data){
		Node<T> current = this.head;
		Node<T> temp = new Node<>(data);
		while(current != null){
			if(node.data.equals(current.data)){
				if(current.prv == null){
					current.prv = temp;
					temp.next = current;
					this.head = temp;
					return true;
				}else{
					current.prv.next = temp;
					temp.prv = current.prv;
					current.prv = temp;
					temp.next = current;
					return true;
				}
				
			}
			
			current = current.next;
		}
		
		return false;
	}
	/**
	 * Append the data at the end of the linked list
	 * @param data
	 */
	public void append(T data){
		Node<T> current = this.head;
		if(this.head == null){
			this.head = current;
			return;
		}
		while(current != null){
			if(current.next == null){
				current.next = new Node<T>(data);
				return;
			}
			current = current.next;
		}
	}
	/**
	 * Remove the given data from the linked list
	 * @param data
	 * @return
	 */
	public boolean remove(T data){
		Node<T> current = this.head;
		boolean found = false;
		while(current != null){
			if(current.data.equals(data)){
				found = true;
				if(current == head){
					this.head = current.next;
				}else{
					if(current.prv != null){
						current.prv.next = current.next;
					}
					if(current.next != null){
						current.next.prv=current.prv;
					}
				}
				break;
			}else{
				current = current.next;
			}
		}
		return found;
	}
	/**
	 * Search the given data in the linked list. 
	 * @param data
	 * @return
	 */
	public T search(T data){
		
		Node<T> current = this.head;
		while(current != null){
			if(current.data.equals(data)){
				return data;
			}else{
				current = current.next;
			}
		}
		
		return null;
	}
	/**
	 * Return the length of the LinkedList.
	 * @return
	 */
	public int size(){
		int len = 0;
		Node<T> current = this.head;
		while(current != null){
			current = current.next;
			len++;
		}
		
		return len;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		Node<T> current = this.head;
		int i = 0;
		while(current != null){
			if(i == 0){
				builder.append("[").append(current.data).append("]");
			}else{
				builder.append("-->").append("[").append(current.data).append("]");
			}
			i++;
			
			current = current.next;
		}
		
		
		return builder.toString().length() > 0?builder.toString():"[]";
		
	}
	
}
