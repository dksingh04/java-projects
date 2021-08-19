package com.dk.dp;

import java.util.Scanner;

public class MaximumSumIncreasingSequence {
    public static void main(String ...args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int [] dp = new int[n];
        int omax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            Integer max = null;
            for(int j = 0; j < i; j++ ){
                if(arr[j] < arr[i]){
                    if(max == null){
                        max = dp[j];
                    }else if(dp[j] > max){
                        max = dp[j];
                    }
                }

            }

            if(max == null){
                dp[i] = arr[i];
            }else{
                dp[i] = max + arr[i];
            }

            if(dp[i] > omax){
                omax = dp[i];
            }
        }

        System.out.println(omax);
    }
}
