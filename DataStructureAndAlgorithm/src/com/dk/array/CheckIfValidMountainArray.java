package com.dk.array;

public class CheckIfValidMountainArray {
    public static void main(String ...args){
        System.out.println(validMountainArray(new int [] {2,1}));
        System.out.println(validMountainArray(new int [] {3,5,5}));
        System.out.println(validMountainArray(new int [] {0,3,2,1}));
    }

    public static boolean validMountainArray(int [] nums){
        int i = 0;
        int len = nums.length;
        //Walk Up
        while(i + 1 < len && nums[i] < nums[i+1]){
            i++;
        }

        if(i == 0 || i == len - 1){
            return false;
        }

        //Walk down
        while(i + 1 < len && nums[i] > nums[i+1]){
            i++;
        }

        if(i == len -1){
            return true;
        }

        return false;
    }
}
