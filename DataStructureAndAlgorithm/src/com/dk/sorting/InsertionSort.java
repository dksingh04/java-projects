package com.dk.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort obj = new InsertionSort();
		int arr[] = new int [] {5,4,1,2,8};
		obj.insertionSort(arr);
		
		obj.printArray(arr);
	}
	
	public void insertionSort(int ...arr) {
		int j = 0;
		int key;
		for(int i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i-1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			
			arr[j+1] = key;
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
