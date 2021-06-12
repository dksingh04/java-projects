package com.dk.array;

import java.util.Arrays;

public class MoveAllZerosRight {
    public static void main(String ...args){
        int[] v = new int[]{1, 10, 20, 0, 63, 59, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveZeroesRight(v);

        System.out.println("After Moving Zeroes to Right: " + Arrays.toString(v));
    }
    public static void moveZeroesRight(int[] nums) {
        int readIndex = 0;
        int writeIndex = 0;

        while(readIndex < nums.length){
            if(nums[readIndex] != 0){
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        while(writeIndex < nums.length){
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
}
