package com.dk.array;

import java.util.Arrays;

public class MoveAllZerostoLeft {

    public static void main(String ...args){
        int[] v = new int[]{1, 10, 20, 0, 63, 59, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveAllZerosToLeft(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }

    public static void moveAllZerosToLeft(int []A){
        int len = A.length;
        if(len < 1){
            return;
        }
        int readIndex = len - 1;
        int writeIndex = len - 1;
        while(readIndex >= 0){
            if(A[readIndex] != 0){
                A[writeIndex] = A[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while(writeIndex >= 0){
            A[writeIndex]  = 0;
            writeIndex--;
        }
    }
}
