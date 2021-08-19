package com.dk.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	
	private List<T> stack;
	
	public Stack(){
		stack = new ArrayList<>();
	}
	
	public void push(T data){
		stack.add(data);
	}
	
	public T pop(){
		T data = null;
		if(!isEmpty()){
			//data = stack.get(stack.size()-1);
			data = stack.remove(stack.size()-1);
		}else{
			System.out.println("Stack is Empty!!");
		}
		return data;
	}
	
	public boolean isEmpty(){
		if(stack!=null && stack.size() == 0){
			return true;
		}
		return false;
	}

	public T peek(){
		T data = null;
		if(!isEmpty()){
			data = stack.get(stack.size()-1);
			//data = stack.remove(stack.size()-1);
		}else{
			System.out.println("Stack is Empty!!");
		}
		return data;
	}
	
	public void printData(){
		for(T d: stack){
			System.out.print(d.toString()+" ");
		}
	}
	
	
}
 