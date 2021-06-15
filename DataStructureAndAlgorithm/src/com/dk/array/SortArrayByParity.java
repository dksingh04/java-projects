package com.dk.array;

import java.util.Arrays;

public class SortArrayByParity {
    /*
    Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.
    You may return any answer array that satisfies this condition.

    Example 1:

    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

   */

    public static void main(String ...args){
        System.out.println(Arrays.toString(sortArrayByParity(new int [] {3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int [] {0,0})));
        System.out.println(Arrays.toString(sortArrayByParity(new int [] {0,1})));
        System.out.println(Arrays.toString(sortArrayByParity(new int [] {0})));

        System.out.println(Arrays.toString(sortArrayByParity(new int [] {2,4,6})));
        System.out.println(Arrays.toString(sortArrayByParity(new int [] {2,4,6, 1})));

        System.out.println(Arrays.toString(sortArrayByParitySimple(new int [] {3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParitySimple(new int [] {0,0})));
        System.out.println(Arrays.toString(sortArrayByParitySimple(new int [] {0,1})));
        System.out.println(Arrays.toString(sortArrayByParitySimple(new int [] {0})));

        System.out.println(Arrays.toString(sortArrayByParitySimple(new int [] {2,4,6})));
        System.out.println(Arrays.toString(sortArrayByParitySimple(new int [] {2,4,6, 1})));

        System.out.println(Arrays.toString(sortArrayByParitySimplest(new int [] {3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParitySimplest(new int [] {0,0})));
        System.out.println(Arrays.toString(sortArrayByParitySimplest(new int [] {0,1})));
        System.out.println(Arrays.toString(sortArrayByParitySimplest(new int [] {0})));

        System.out.println(Arrays.toString(sortArrayByParitySimplest(new int [] {2,4,6})));
        System.out.println(Arrays.toString(sortArrayByParitySimplest(new int [] {2,4,6, 1})));


    }

    public static int[] sortArrayByParity(int[] nums) {
        int readIndex = 0;
        int writeIndex = 0;
        int len = nums.length;

        while (readIndex < len) {
            if (nums[readIndex] % 2 == 0 && nums[writeIndex] % 2 != 0 && writeIndex < readIndex) {
                int temp = nums[writeIndex];
                nums[writeIndex] = nums[readIndex];
                nums[readIndex] = temp;
                writeIndex++;

            }
            if (nums[writeIndex] % 2 == 0) {
                writeIndex++;
            }

            readIndex++;
        }

        return nums;
    }

    //Simple approach
    public static int [] sortArrayByParitySimple(int [] nums){
        int l = 0;
        int r  = nums.length - 1;

        while(l < r){
            if(nums[l] % 2 != 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
                l++;
            }else{
                l++;
            }
        }

        return nums;
    }

    //Simplest approach
    public static int [] sortArrayByParitySimplest(int [] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] % 2 > nums[r] % 2){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if(nums[l] % 2 == 0){
                l++;
            }

            if(nums[r] % 2 != 0){
                r--;
            }
        }
        return nums;

    }



}
