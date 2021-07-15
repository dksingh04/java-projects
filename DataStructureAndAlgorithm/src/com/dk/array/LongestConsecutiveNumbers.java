package com.dk.array;

import java.util.PriorityQueue;

public class LongestConsecutiveNumbers {
    public static void main(String ...args){
        System.out.println(longestConsecutive(new int [] {0,3,7,2,5,8,4,6,0,1}));
    }
    public static int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
        }

        int max = 0;
        int size = 0;
        int preVal = 0;
        if(!queue.isEmpty()){
            preVal = queue.poll();
            size++;
        }
        while(!queue.isEmpty()){
            int val = queue.poll();
            if(val == preVal){
                continue;
            }
            if(val - 1 == preVal){
                size++;
                preVal = val;
            }else{
                if(max < size){
                    max = size;
                }
                preVal = val;
                size = 1;
            }
        }

        if(max <= size){
            max = size;
        }

        return max;
    }
}
