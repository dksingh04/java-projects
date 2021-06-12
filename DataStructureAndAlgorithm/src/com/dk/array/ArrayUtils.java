package com.dk.array;

public class ArrayUtils {

    public static void print(int [] arr){
        System.out.print("[");
        for(int i  = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i < arr.length - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
        System.out.println("Length: "+arr.length);
    }
}
