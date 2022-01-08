package com.dk.array;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    /*
       Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

        An integer a is closer to x than an integer b if:

        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b


        Example 1:

        Input: arr = [1,2,3,4,5], k = 4, x = 3
        Output: [1,2,3,4]
        Example 2:

        Input: arr = [1,2,3,4,5], k = 4, x = -1
        Output: [1,2,3,4]
     */

    public static void main(String ...args){
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int xIndex = findTheIndexOftheElement(arr, 0, arr.length - 1, x);
        List<Integer> result = new ArrayList<>(k);
        result.add(arr[xIndex]);
        int left = xIndex - 1;
        int right = xIndex + 1;
        while(result.size() < k){
            if(left >=0 && right < arr.length){
                if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                    result.add(0, arr[left]);
                    left--;
                }else{
                    result.add(arr[right]);
                    right++;
                }
            }else if(left >= 0){
                result.add(0, arr[left]);
                left--;
            }else if((right - left) <= k && right < arr.length){
                result.add(arr[right]);
                right++;
            }
        }

        return result;
    }

    public static int findTheIndexOftheElement(int []arr, int start, int end, int target){

        if(start > end){
            if(start >= arr.length){
                //crossed the right side.
                return arr.length - 1;
            }else if(start < arr.length && start - 1 < arr.length && start - 1 > -1 && Math.abs(target - arr[start -1]) <= Math.abs(target - arr[start])){
                return start - 1;
            }else if(start < 0){
                return 0;
            }else {
                return start;
            }
        }

        int mid = (start + end) >>> 1;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid] < target){
            return findTheIndexOftheElement(arr, mid+1, end, target);
        }else{
            return findTheIndexOftheElement(arr, start, mid - 1, target);
        }

    }
}
