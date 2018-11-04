package com.dk.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	private List<T> queue;
	
	public Queue(){
		queue = new ArrayList<>();
	}
	
	public void add(T data){
		queue.add(data);
	}
	
	public T remove(){
		T data = null;
		if(!isEmpty()){
			data = queue.remove(0);
		}else{
			System.out.println("Queue is Empty!!");
		}
		return data;
	}
	
	public boolean isEmpty(){
		if(queue!=null && queue.size() == 0){
			return true;
		}
		return false;
	}
	
	public void printData(){
		for(T d: queue){
			System.out.print(d.toString()+" ");
		}
	}
}
