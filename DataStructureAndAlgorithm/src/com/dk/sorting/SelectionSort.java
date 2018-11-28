package com.dk.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort obj = new SelectionSort(); 
        int arr[] = {64,25,12,22,11}; 
        obj.selectionSort(arr); 
        System.out.println("Sorted array"); 
        obj.printArray(arr);
	}
	
	public void selectionSort(int ...args) {
		if(args!=null && args.length > 0) {
			int n = args.length;
			int min_idx = 0;
			for(int i = 0; i < n-1; i++) {
				min_idx = i;
				for(int j = i+1; j < n; j++) {
					if(args[j] < args[min_idx]) {
						min_idx = j;
					}
				}
				// swap once minimum is found
				int temp = args[i];
				args[i] = args[min_idx];
				args[min_idx] = temp;
			}
		}else {
			System.out.println("Array is empty or null!!");
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
