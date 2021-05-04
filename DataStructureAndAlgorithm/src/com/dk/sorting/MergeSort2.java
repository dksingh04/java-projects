package com.dk.sorting;

public class MergeSort2 {
    public static void main(String ...args){
        int arr[] = new int [] {5,4,1,2,8};
        int temp[] = new int[5];
        mergesort(arr, temp, 0, arr.length-1);

        printArray(arr);
    }

    public static void mergesort(int[] arr, int[] temp, int leftStart, int rightEnd){
        if(leftStart < rightEnd){
            int middle = (leftStart + rightEnd) / 2;
            mergesort(arr, temp, leftStart, middle);
            mergesort(arr, temp, middle+1, rightEnd);
            merge(arr, temp, leftStart, rightEnd);
        }
    }

    public static  void merge(int [] arr, int [] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right]){
                temp[index] = arr[left];
                left++;
            }else{
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        // copy remaining left data
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        // copy remaining right data
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        // copy temp date to array back.
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }

    public static void printArray(int ...arr) {
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
