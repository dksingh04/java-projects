package com.dk.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSumOfArray {
    public static void main(String ...args){
        List<Integer> result = bestTargetSum(new int[]{5,4,3,7}, 7);
        result.stream().forEach(System.out::print);

        System.out.println();
        result = bestTargetSum(new int[]{2,3,5}, 8);
        result.stream().forEach(System.out::print);
        System.out.println();

        result = bestTargetSum(new int[]{1, 4, 5}, 8);
        result.stream().forEach(System.out::print);
        System.out.println();

       /*
        //Uncommenting this will make your program hang.
        long startTime = System.currentTimeMillis();
        result = bestTargetSum(new int[]{1, 2, 5, 25}, 75);
        result.stream().forEach(System.out::print);
        System.out.println(String.format("ResponseTime of bestTargetSum without Memoization for target sum %d is %d ms",75, System.currentTimeMillis() - startTime));
       */

        System.out.println();

        long startTime = System.currentTimeMillis();
        Map<Integer, List<Integer>> memo = new HashMap<>();
        result = bestTargetSumMemo(new int[]{1, 2, 5, 25}, 100, memo);
        result.stream().forEach(System.out::print);
        System.out.println();
        System.out.println(String.format("ResponseTime of bestTargetSumMemo with Memoization for target sum %d %d ms",100, System.currentTimeMillis() - startTime));
    }

    public static List<Integer> bestTargetSum(int [] nums, int target){
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;
        List<Integer> shortestList = null;
        for(int i = 0; i < nums.length; i++){
            List<Integer> bestSumList = bestTargetSum(nums, target - nums[i]);
            if(bestSumList != null){
                List<Integer> combinationList = new ArrayList<>(bestSumList);
                combinationList.add(nums[i]);
                if(shortestList == null || combinationList.size() < shortestList.size()){
                    shortestList = combinationList;
                }
            }
        }


        return shortestList;
    }

    public static List<Integer> bestTargetSumMemo(int [] nums, int target, Map<Integer, List<Integer>> memo){
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;
        if(memo.get(target) != null){
            return memo.get(target);
        }
        List<Integer> shortestList = null;
        for(int i = 0; i < nums.length; i++){
            List<Integer> bestSumList = bestTargetSumMemo(nums, target - nums[i], memo);
            if(bestSumList != null){
                List<Integer> combinationList = new ArrayList<>(bestSumList);
                combinationList.add(nums[i]);
                if(shortestList == null || combinationList.size() < shortestList.size()){
                    shortestList = combinationList;
                }
            }
        }
        memo.put(target, shortestList);

        return shortestList;
    }
}
