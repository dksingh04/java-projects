package com.dk.array;

import java.util.Arrays;

public class RemoveGivenElements {

    /*
    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2]
    Explanation: Your function should return length = 2, with the first two elements of nums being 2.
    It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.

     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        while(i < length){
            if(nums[i] == val){
                int j = i+1;
                while(j < length){
                    nums[j-1] = nums[j];
                    j++;
                }
                length--;
                continue;
            }
            i++;
        }

        return length;
    }

    public static int removeElementON(int[] nums, int val) {
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;
                i++;
            }
        }
        return i;
    }

    public static void main(String ...args){
        int [] nums = new int[]{3,2,2,3};
        int val = 3;

        int len = removeElement(nums, 3);
        System.out.print("[");
        for(int i  = 0; i < len; i++){
            System.out.print(nums[i]);
            if(i < len - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
        System.out.println("Length: "+len);

        int [] nums1 = new int[]{3,2,2,3};
        int val1 = 3;

        int len1 = removeElementON(nums, 3);

        ArrayUtils.print(nums);
    }
}
