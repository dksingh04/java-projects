package com.dk.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumber {

    public static void main(String ...args){
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[]{7,9,8,11,12}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(Math.abs(nums[i]) <= len && nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }

        for(int i = 0; i < len; i++){
           if(nums[i] > 0){
               result.add(i + 1);
           }
        }

        return result;
    }
}
