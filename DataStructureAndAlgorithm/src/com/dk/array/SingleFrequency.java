package com.dk.array;

import java.util.*;

public class SingleFrequency {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <  nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry:  map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return - 1;
    }

    //Bitwise operator soln
    public static int singleNumberBitWise(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String ...args){
        System.out.println(singleNumber(new int []{2,2,1}));
        System.out.println(singleNumberBitWise(new int []{2,2,1, 2}));
    }
}
