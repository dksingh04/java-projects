package com.dk.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String ...args){
        int[] a = new int[] {55, 23, 26, 2, 18, 78, 23, 8, 2, 3};
        int[] b = new int[] {33, 6, 21, 12, 19, 29, 38, 22, 14, 40};
        System.out.print("Before Sorting\n");
        System.out.print(Arrays.toString(a) + "\n");

        quickSort(a, 0, a.length-1);

        System.out.print("After Sorting\n");
        System.out.println(Arrays.toString(a));

        System.out.print("Before Sorting\n");
        System.out.print(Arrays.toString(b) + "\n");

        quickSort(b, 0, b.length-1);

        System.out.print("After Sorting\n");
        System.out.print(Arrays.toString(b));
    }

    public static void quickSort(int [] arr, int left, int right){
        if(right > left){
            //get the partition index
            int index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }

    }

    private static int partition(int [] arr, int left, int right){
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            while(i <= right && arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i < j){
                swap(arr, i, j);
            }
        }

        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void swap(int [] arr, int left, int right){
        arr[left] ^= arr[right];
        arr[right] ^= arr[left];
        arr[left] ^= arr[right];
    }
}
