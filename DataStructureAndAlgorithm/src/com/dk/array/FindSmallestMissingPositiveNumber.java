package com.dk.array;

public class FindSmallestMissingPositiveNumber {
    /*
    Given an unsorted integer array nums, find the smallest missing positive integer.
    You must implement an algorithm that runs in O(n) time and uses constant extra space.

    Example 1:

    Input: nums = [1,2,0]
    Output: 3

    Example 2:

    Input: nums = [3,4,-1,1]
    Output: 2

    Example 3:

    Input: nums = [7,9,8,11,12]
    Output: 1
     */

    public static void main(String ...args){
        System.out.println(findSmallestMissingNumber(new int[]{1,2,0}));
        System.out.println(findSmallestMissingNumber(new int[]{7,9,8,11,12}));
        System.out.println(findSmallestMissingNumber(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findSmallestMissingNumber(new int[]{3,4,-1,1}));
        System.out.println(5^2);
    }

    public static int findSmallestMissingNumber(int [] nums){
        int len = nums.length;

        //If array contains negative number then move negative to end.
        len = moveNegativeNumsAtEnd(nums);

        for(int i =0; i < len; i++){
            if(Math.abs(nums[i]) > 0 && Math.abs(nums[i]) <= len && nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for(int j =0; j < len; j++){
            if(nums[j] >= 0){
                return j + 1;
            }
        }
        return 1;
    }

    public static int moveNegativeNumsAtEnd(int[] nums){
        int len = nums.length;
        int writeIndex = 0;
        int newLen = len;
        int readIndex = 0;
        while(readIndex < len){
            if(nums[readIndex] >= 0){
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }else{
                newLen--;
            }
            readIndex++;

        }

        return newLen;
    }
}
