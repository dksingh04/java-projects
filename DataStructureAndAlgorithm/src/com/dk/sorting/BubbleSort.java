package com.dk.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		int arr[] = new int [] {5,4,1,2,8};
		obj.bubbleSort(arr);
		
		obj.printArray(arr);
	}
	
	public void bubbleSort(int ...arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =  temp;
				
				}
			}
		}
	}
	
	public void printArray(int ...arr) {
		StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(int i = 0; i<arr.length; i++) {
        	builder.append(arr[i]).append(", ");
        }
        
        builder.delete(builder.length()-2, builder.length());
        
        builder.append("}");
        
        System.out.println(builder.toString());
	}

}
