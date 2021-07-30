package com.dk.array;

import java.util.ArrayList;
import java.util.List;

public class PartitionDisjoint {

    public static void main(String ...args){
        System.out.println(partitionDisjoint(new int[]{53,58,37,39,61,68,3,64,2,99}));
        System.out.println(partitionDisjoint(new int[]{55,59,38,44,54,97,60,60,71,82}));
    }

    public static int partitionDisjoint(int[] nums) {
        int lLength = 1;
        int max = nums[0];
        int maxEncountered = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxEncountered = Math.max(maxEncountered, nums[i]);
            if(nums[i] < max){
                max = maxEncountered;
                lLength = i + 1;
            }

        }
        return lLength;
    }
}
