package com.dk.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestConsecutiveNumbersSet {
    public static void main(String ...args){
        System.out.println(longestConsecutive(new int [] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int [] {100,4,200,1,3,2}));

        System.out.println(Integer.bitCount(1 ^ 2));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        Arrays.stream(nums).forEach(n -> {
            numSet.add(n);
        });
        int longestSeq = 0;
        for(int num:numSet){
            if(!numSet.contains(num -1)){
                int currentNum = num;
                int currentSeq = 1;
                while(numSet.contains(currentNum +1)){
                    currentSeq++;
                    currentNum++;
                }

                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }

        return longestSeq;
    }
}
