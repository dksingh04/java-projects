package com.dk.array;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNsDoubleExist {
    /*

        Example 1:

        Input: arr = [10,2,5,3]
        Output: true
        Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
        Example 2:

        Input: arr = [7,1,14,11]
        Output: true
        Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
        Example 3:

        Input: arr = [3,1,7,11]
        Output: false
        Explanation: In this case does not exist N and M, such that N = 2 * M.

     */

    public static void main(String ...args){
       System.out.println(checkIfExist(new int []{10,2,5,3}));
        System.out.println(checkIfExist(new int []{7,1,14,11}));
        System.out.println(checkIfExist(new int []{3,1,7,11}));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int zero = 0;
        for(int j = 0; j < arr.length; j++){
            set.add(arr[j]);
            if(arr[j] == 0){
                zero++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0 && zero > 1){
                return true;
            }
            if(arr[i] != 0 && set.contains(arr[i]*2)){
                return true;
            }
        }
        return false;
    }
}
