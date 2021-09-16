package com.dk.array;

public class LargestSumSubArray {
    public static void main(String ...args){
        //Kadane’s algorithm
        System.out.println(findMaximumSubArray(new int[]{-4,2,-5,1,2,3,6,-5,1}));
    }

    public static int findMaximumSubArray(int [] arr){
        int currentMax = arr[0];
        int globalMax = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(currentMax < 0){
                currentMax = arr[i];
            }else{
                currentMax = currentMax + arr[i];
            }

            if(globalMax < currentMax){
                globalMax = currentMax;
            }
        }

        return globalMax;
    }
}
