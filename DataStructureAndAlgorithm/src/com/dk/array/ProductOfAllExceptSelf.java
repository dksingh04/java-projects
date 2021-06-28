package com.dk.array;

import java.util.Arrays;

public class ProductOfAllExceptSelf {
    public static void main(String ...args){
        int [] res = productOfAll(new int[]{4, 2, 4, 6});
        System.out.println(Arrays.toString(res));
    }

    public static int [] productOfAll(int [] nums){
        int l = nums.length;
        int [] r = new int[l];
        r[l - 1] = 1;

        for(int i = l - 2; i >=0; i--){
            r[i] = r[i+1] * nums[i+1];
        }

        int left = 1;
        for(int i = 0; i < l; i++){
            r[i] = r[i] * left;
            left *= nums[i];
        }
        return r;
    }
}
