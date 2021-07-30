package com.dk.dp;

import java.util.HashMap;
import java.util.Map;

public class CanSumofTwoExists {
    /*
       Solve the problem using Dynamic programming.
     */
    public static void main(String ...args){
        System.out.println(canSum(new int[]{2,3}, 2, 7));
        System.out.println(canSum(new int[]{5,3,4,7}, 4, 7));
        System.out.println(canSum(new int[]{2,3,5}, 3, 8));
        long startTime = System.currentTimeMillis();
        System.out.println(canSum(new int[]{3,4}, 2, 800));
        System.out.println(String.format("ResponseTime of SumOfSubset without Memoization %d ms",System.currentTimeMillis() - startTime));
        Map<Integer, Boolean> cache = new HashMap<>();
        System.out.println(canSumMemo(new int[]{2,3}, 2, 7, cache));
        cache = new HashMap<>();
        System.out.println(canSumMemo(new int[]{5,3,4,7}, 4, 7, cache));
        cache = new HashMap<>();
        System.out.println(canSumMemo(new int[]{2,3,5}, 3, 8, cache));
        cache = new HashMap<>();
        startTime = System.currentTimeMillis();
        System.out.println(canSumMemo(new int[]{3,4}, 2, 800, cache));
        System.out.println(String.format("ResponseTime of SumOfSubset with Memoization %d ms",System.currentTimeMillis() - startTime));
    }

    //Brute-Force approach
    public static boolean canSum(int [] arr, int n, int target){
        if(target == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(arr[n -1] > target){
            return canSum(arr, n - 1, target);
        }

        return canSum(arr, n - 1, target) || canSum(arr, n - 1, target - arr[n-1]);
    }


    //Using Memoization
    public static boolean canSumMemo(int [] arr, int n, int target, Map<Integer, Boolean> cache){
        if(target == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(cache.get(target)!= null){
            return cache.get(target);
        }

        if(arr[n -1] > target){
            cache.put(target, canSum(arr, n - 1, target));
        }

         cache.put(target, canSum(arr, n - 1, target) || canSum(arr, n - 1, target - arr[n-1]));

        return cache.get(target);
    }



}
