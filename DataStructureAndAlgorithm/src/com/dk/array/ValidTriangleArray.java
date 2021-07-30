package com.dk.array;

import java.util.Arrays;

public class ValidTriangleArray {
    /*
       Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

        Example 1:

        Input: nums = [2,2,3,4]
        Output: 3
        Explanation: Valid combinations are:
        2,3,4 (using the first 2)
        2,3,4 (using the second 2)
        2,2,3
        Example 2:

        Input: nums = [4,2,3,4]
        Output: 4
        a+b > c is a triangle formula.
     */

     public static void main(String ...args){
        System.out.println(validTriangle(new int[]{4,2,3,4}));
     }

     public static int validTriangle(int [] nums){
         int count = 0;
         Arrays.sort(nums);
         for(int i = 0; i < nums.length - 2; i++){
             int k = i + 2;
             for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++){
                 while(k < nums.length && nums[i] + nums[j] > nums[k]){
                     k++;
                 }

                 count += k - j - 1;
             }
         }
         return count;
     }
}
