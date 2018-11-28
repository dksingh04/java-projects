package com.dk.sorting;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort obj = new MergeSort();
		int arr[] = new int [] {5,4,1,2,8};
		obj.mergeSort(arr, 0, arr.length-1);
		
		obj.printArray(arr);
	}
	
	public void merge(int [] arr, int l, int m, int r) {
		int nL = m-l+1;
		int nR = r - m;
		
		int [] L = new int[nL];
		int [] R = new int[nR];
		// copy left array and right array
		for(int i = 0; i < nL; i++) {
			L[i] = arr[l+i];
		}
		
		for(int j = 0; j < nR; j++) {
			R[j] = arr[m+1+j];
		}
		
		int i = 0, j = 0;
		int k = l;
		//sort the array
		while(i < nL && j < nR) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			
			k++;
		}
		
		
		//copy rest of the data
		while(i < nL) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < nR) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
	}
	
	public void mergeSort(int [] arr, int l, int r) {
		
		if(l < r) {
			int m = (l + r)/2;
			
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			merge(arr, l, m, r);
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
