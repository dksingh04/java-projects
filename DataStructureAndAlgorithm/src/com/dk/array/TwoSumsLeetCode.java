package com.dk.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumsLeetCode {

    /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.



        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], t-> new ArrayList<>()).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            if(map.containsKey(target - entry.getKey())){
                List<Integer> valList = entry.getValue();
                if(valList.size() > 1){
                    res[0] = valList.get(0);
                    res[1] = valList.get(1);
                }else{
                    res[1] = entry.getValue().get(0);
                    res[0] = map.get(target - entry.getKey()).get(0);
                }

            }
        }

        return res;
    }
}
