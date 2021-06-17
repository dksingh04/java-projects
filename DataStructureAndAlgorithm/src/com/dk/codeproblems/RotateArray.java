package com.dk.codeproblems;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    /*
        Given an array of integers, rotate the array by NN elements where NN is an integer:

        For positive values of NN, perform a right rotation.
        For negative values of NN, perform a left rotation.
        Make sure you make changes to the original array.
     */

    public static void reverseArray(List<Integer> arr, int start, int end){
        while(start < end){
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    public static void rotateArray(List<Integer> arr, int n){
        //First is to normalize the roataion and also convert negative rotation to positive
        int size = arr.size();
        n = n % size;
        if(n < 0){
            n = n + size;
        }

        //Now we can do the rotation in 3 part
        //1. 0, size-1
        //2. 0, n-1
        //3. n, size-1
        reverseArray(arr, 0, size-1);
        reverseArray(arr, 0, n-1);
        reverseArray(arr, n, size-1);
    }

    public static void rotateArraySimpleApproach(List<Integer> arr, int n){
        int size = arr.size();
        n = n % size;
        if(n  < 0){
            n = n + size;
        }
        int i = 0;
        while( n > 0){
            int elem = arr.get((size - n));
            swap(arr, (size - n), i);
            n--;
            arr.set(i, elem);
            i++;
        }

        //reverseArray(arr, 0, n - 1);
    }

    private static void swap(List<Integer> arr, int end, int start){
        while(end > start){
            arr.set(end, arr.get(end - 1));
            end--;
        }
    }

    public static void main(String ...args){
        List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n"+arr);
        rotateArray(arr, 2);
        System.out.println("Array After Rotation\n"+arr);

        System.out.println("Reverse Rotation by -2\n");
        System.out.println("Array Before Reverse Rotation\n"+arr);
        rotateArray(arr, -2);
        System.out.println("Array after Reverse Rotation\n"+arr);

        List<Integer> arr2 = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n"+arr2);
        rotateArraySimpleApproach(arr2, 2);
        System.out.println("Array After Rotation\n"+arr2);

        List<Integer> arr3 = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n"+arr3);
        rotateArraySimpleApproach(arr2, -2);
        System.out.println("Array After Rotation\n"+arr3);

    }
}
